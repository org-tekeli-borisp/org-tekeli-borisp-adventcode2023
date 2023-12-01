package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    private String givenCalibrationDocumentLine() {
        return "Some content";
    }
}
