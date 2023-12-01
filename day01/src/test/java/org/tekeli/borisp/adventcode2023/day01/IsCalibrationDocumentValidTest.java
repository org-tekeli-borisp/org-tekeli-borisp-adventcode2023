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

    @Test
    void shouldProduceFalseIncaseCalibrationDocumentIsNull() {

        final boolean product = sus.test(null);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseIncaseCalibrationDocumentHasNullContent() {
        final var calibrationDocument =  new CalibrationDocument(null);

        final boolean product = sus.test(calibrationDocument);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceTrueOtherwise() {
        final var calibrationDocument =  new CalibrationDocument("Some content");

        final boolean product = sus.test(calibrationDocument);

        assertThat(product).isTrue();
    }
}