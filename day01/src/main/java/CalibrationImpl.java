import java.util.Optional;

public class CalibrationImpl implements Calibration {
    @Override
    public Optional<CalibrationSum> apply(CalibrationDocument calibrationDocument) {

        return Optional.of(new  CalibrationSum());
    }
}
