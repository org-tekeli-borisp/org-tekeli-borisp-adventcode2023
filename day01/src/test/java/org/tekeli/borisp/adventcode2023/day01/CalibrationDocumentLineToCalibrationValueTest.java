package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CalibrationDocumentLineToCalibrationValueTest {


    private CalibrationDocumentLineToCalibrationValue sus;

    @BeforeEach
    void setUp() {
        sus = new CalibrationDocumentLineToCalibrationValueImpl();
    }

    @Test
    void shouldConsumeString() {
        final var calibrationDocumentLine = givenCalibrationDocumentLine();

        assertThatNoException().isThrownBy(() -> sus.apply(calibrationDocumentLine));
    }

    @Test
    void shouldProduceCalibrationValue() {
        final var calibrationDocumentLine = givenCalibrationDocumentLine();

        final var product = sus.apply(calibrationDocumentLine);

        assertThat(product).isInstanceOf(CalibrationValue.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    void shouldProduceZeroInCaseCalibrationDocumentLineWithoutNumbers(final String calibrationDocumentLineWithoutNumbers) {
        final var product = sus.apply(calibrationDocumentLineWithoutNumbers);

        assertThat(product.getValue()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a1", "a1b"})
    void shouldProduceValueFormSingleNumber(final String calibrationDocumentLineWithoutNumbers) {
        final var product = sus.apply(calibrationDocumentLineWithoutNumbers);

        assertThat(product.getValue()).isEqualTo(11L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"42", "4a2", "4a2b", "a4b2", "a42", "4ab5cd2d"})
    void shouldProduceNumberValueFromFirstAndLastNumbers(final String calibrationDocumentLineWithoutNumbers) {
        final var product = sus.apply(calibrationDocumentLineWithoutNumbers);

        assertThat(product.getValue()).isEqualTo(42L);
    }

    private String givenCalibrationDocumentLine() {
        return "Some content";
    }
}
