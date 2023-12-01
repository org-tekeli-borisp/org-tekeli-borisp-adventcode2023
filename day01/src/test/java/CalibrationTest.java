import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void shouldProduceCalibrationSum() {
        final var calibrationDocument = mock(CalibrationDocument.class);

        final var  product = sus.apply(calibrationDocument);

        assertThat(product).isInstanceOf(CalibrationSum.class);
    }
}
