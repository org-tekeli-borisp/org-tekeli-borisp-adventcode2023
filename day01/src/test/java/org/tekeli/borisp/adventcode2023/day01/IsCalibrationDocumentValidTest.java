package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

class IsCalibrationDocumentValidTest {

    private IsCalibrationDocumentValid sus;

    @BeforeEach
    void setUp() {
        sus = new IsCalibrationDocumentValidImpl();
    }

    @Test
    void shouldConsumeCalibrationDocument() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        assertThatNoException().isThrownBy(() -> sus.test(calibrationDocument));
    }

    @Test
    void shouldProduceBoolean() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        final boolean product = sus.test(calibrationDocument);

        assertThat(product).isInstanceOf(Boolean.class);
    }
}