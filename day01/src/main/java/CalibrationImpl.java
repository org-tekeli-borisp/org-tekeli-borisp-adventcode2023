import java.util.Optional;

public class CalibrationImpl implements Calibration {
    @Override
    public Optional<CalibrationSum> apply(final CalibrationDocument calibrationDocument) {
        return Optional
                .ofNullable(calibrationDocument)
                .map(this::map);
    }

    private CalibrationSum map(final CalibrationDocument calibrationDocument) {
        return new CalibrationSum();
    }
}
