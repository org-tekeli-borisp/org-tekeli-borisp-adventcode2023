package org.tekeli.borisp.adventcode2023.day01;

import java.util.Optional;

class CalibrationImpl implements Calibration {

    private final IsCalibrationDocumentValid isCalibrationDocumentValid;

    CalibrationImpl(IsCalibrationDocumentValid isCalibrationDocumentValid) {
        this.isCalibrationDocumentValid = isCalibrationDocumentValid;
    }

    @Override
    public Optional<CalibrationSum> apply(final CalibrationDocument calibrationDocument) {
        return Optional
                .ofNullable(calibrationDocument)
                .filter(isCalibrationDocumentValid::test)
                .map(this::map);
    }

    private CalibrationSum map(final CalibrationDocument calibrationDocument) {
        return new CalibrationSum();
    }
}
