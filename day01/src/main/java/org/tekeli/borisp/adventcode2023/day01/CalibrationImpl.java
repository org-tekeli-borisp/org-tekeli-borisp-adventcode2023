package org.tekeli.borisp.adventcode2023.day01;

import java.util.Optional;

class CalibrationImpl implements Calibration {

    private final IsCalibrationDocumentValid isCalibrationDocumentValid;
    private final CalibrationDocumentLineToCalibrationValue calibrationDocumentLineToCalibrationValue;

    CalibrationImpl(final IsCalibrationDocumentValid isCalibrationDocumentValid,
                    final CalibrationDocumentLineToCalibrationValue calibrationDocumentLineToCalibrationValue) {
        this.isCalibrationDocumentValid = isCalibrationDocumentValid;
        this.calibrationDocumentLineToCalibrationValue = calibrationDocumentLineToCalibrationValue;
    }

    @Override
    public Optional<CalibrationSum> apply(final CalibrationDocument calibrationDocument) {
        return Optional
                .ofNullable(calibrationDocument)
                .filter(isCalibrationDocumentValid::test)
                .map(this::calculateSum)
                .map(CalibrationSum::new);
    }

    private Integer calculateSum(final CalibrationDocument calibrationDocument) {
        return Optional
                .of(calibrationDocument)
                .map(CalibrationDocument::content)
                .stream()
                .flatMap(String::lines)
                .map(calibrationDocumentLineToCalibrationValue::apply)
                .map(CalibrationValue::getValue)
                .reduce(0, Integer::sum);
    }
}
