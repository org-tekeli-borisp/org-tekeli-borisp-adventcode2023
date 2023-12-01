package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CalibrationTest {

    private Calibration sus;

    @BeforeEach
    void setUp() {
        sus = new CalibrationImpl(new IsCalibrationDocumentValidImpl());
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
    void shouldProduce12InCaseContentIs1abc2() {
        final var calibrationDocument = givenCalibrationDocument();

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(12L);
    }

    private CalibrationDocument givenCalibrationDocument() {
        return new CalibrationDocument("1abc2");
    }

    private CalibrationDocument givenInvalidCalibrationDocument() {
        return new CalibrationDocument(null);
    }
}
