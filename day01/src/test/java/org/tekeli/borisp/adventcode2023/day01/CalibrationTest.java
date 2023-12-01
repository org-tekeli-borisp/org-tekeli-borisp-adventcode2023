package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CalibrationTest {

    private static final String exampleData = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
            """;
    private Calibration sus;

    @BeforeEach
    void setUp() {
        sus = new CalibrationImpl(new IsCalibrationDocumentValidImpl(), new CalibrationDocumentLineToCalibrationValueImpl());
    }

    @Test
    void shouldConsumeCalibrationDocument() {
        final var calibrationDocument = givenCalibrationDocument();

        assertThatNoException().isThrownBy(() -> sus.apply(calibrationDocument));
    }

    @Test
    void shouldProduceOptional() {
        final var calibrationDocument = givenCalibrationDocument();

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isInstanceOf(Optional.class);
    }

    @Test
    void shouldProduceOptionalOfCalibrationSum() {
        final var calibrationDocument = givenCalibrationDocument();

        final var product = sus.apply(calibrationDocument);

        assertThat(product).containsInstanceOf(CalibrationSum.class);
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCalibrationDocumentIsNull() {

        final var product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalPresentInCaseCalibrationDocumentIsNotNull() {
        final var calibrationDocument = givenCalibrationDocument();

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCalibrationDocumentIsNotValid() {
        final var calibrationDocument = givenInvalidCalibrationDocument();

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isEmpty();
    }


    @Test
    void shouldProduce0InCaseNoNumbers() {
        final var calibrationDocument = givenCalibrationDocumentWithContent("""
                no numbers at all
                no numbers at all
                no numbers at all
                """);

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(0);
    }
    @Test
    void shouldProduce12() {
        final var calibrationDocument = givenCalibrationDocumentWithContent("""
                1abc2
                """);

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(12);
    }

    @Test
    void shouldProduce142InCaseOfExampleData() {
        final var calibrationDocument = givenCalibrationDocumentWithContent(exampleData);

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(142);
    }

    private CalibrationDocument givenCalibrationDocument() {
        return givenCalibrationDocumentWithContent(exampleData);
    }

    private CalibrationDocument givenInvalidCalibrationDocument() {
        return givenCalibrationDocumentWithContent(null);
    }

    private CalibrationDocument givenCalibrationDocumentWithContent(final String content) {
        return new CalibrationDocument(content);
    }
}
