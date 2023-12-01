import java.util.Optional;

public interface Calibration {
    Optional<CalibrationSum> apply(final CalibrationDocument calibrationDocument);
}
