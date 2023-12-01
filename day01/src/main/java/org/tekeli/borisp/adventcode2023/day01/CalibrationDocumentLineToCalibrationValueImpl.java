package org.tekeli.borisp.adventcode2023.day01;

import java.util.List;

class CalibrationDocumentLineToCalibrationValueImpl implements CalibrationDocumentLineToCalibrationValue {
    @Override
    public CalibrationValue apply(final String calibrationDocumentLine) {
        return new CalibrationValue(toList(calibrationDocumentLine));
    }

    private List<Character> toList(final String calibrationDocumentLine) {
        return calibrationDocumentLine
                .chars()
                .mapToObj(item -> (char) item)
                .filter(Character::isDigit)
                .toList();
    }
}
