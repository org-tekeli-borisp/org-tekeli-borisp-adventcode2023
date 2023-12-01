package org.tekeli.borisp.adventcode2023.day01;

import java.util.Optional;

class CalibrationImpl implements Calibration {
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
