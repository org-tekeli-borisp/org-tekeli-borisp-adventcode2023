import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

public class CalibrationTest {

    private Calibration sus;

    @BeforeEach
    void setUp() {
        sus = new CalibrationImpl();
    }

    @Test
    void shouldConsumeCalibrationDocument() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        assertThatNoException().isThrownBy(() -> sus.apply(calibrationDocument));
    }

    @Test
    void shouldProduceOptional() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        final var  product = sus.apply(calibrationDocument);

        assertThat(product).isInstanceOf(Optional.class);
    }

    @Test
    void shouldProduceOptionalOfCalibrationSum() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        final var  product = sus.apply(calibrationDocument);

        assertThat(product).containsInstanceOf(CalibrationSum.class);
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCalibrationDocumentIsNull() {

        final var  product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalPresentInCaseCalibrationDocumentIsNotNull() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        final var  product = sus.apply(calibrationDocument);

        assertThat(product).isPresent();
    }
}
