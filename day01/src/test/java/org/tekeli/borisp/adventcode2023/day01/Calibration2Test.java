package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class Calibration2Test {
    private static final String exampleData2 = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
            """;
    private Calibration sus;

    @BeforeEach
    void setUp() {
        sus = new Calibration2Impl(
                new IsCalibrationDocumentValidImpl(),
                new CalibrationDocumentLineToCalibrationValueImpl(),
                new NumberInWordsToNumberAndWordImpl());
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
    void shouldProduce281InCaseOfExampleData2() {
        final var calibrationDocument = givenCalibrationDocumentWithContent(exampleData2);

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(281);
    }

    @Test
    void shouldProduce53921WithInputData2() throws URISyntaxException, IOException {
        final var path = Paths
                .get(Objects.requireNonNull(getClass().getClassLoader().getResource("input2.txt"))
                        .toURI());
        final var content = Files.readAllLines(path).stream().collect(Collectors.joining(System.getProperty("line.separator")));
        final var calibrationDocument = givenCalibrationDocumentWithContent(content);

        final var product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
        final var calibrationSum = product.get();
        assertThat(calibrationSum.value()).isEqualTo(54676);
    }

    private CalibrationDocument givenCalibrationDocument() {
        return givenCalibrationDocumentWithContent(exampleData2);
    }

    private CalibrationDocument givenInvalidCalibrationDocument() {
        return givenCalibrationDocumentWithContent(null);
    }

    private CalibrationDocument givenCalibrationDocumentWithContent(final String content) {
        return new CalibrationDocument(content);
    }
}
