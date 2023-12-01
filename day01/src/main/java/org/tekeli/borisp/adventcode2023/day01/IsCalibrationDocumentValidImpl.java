package org.tekeli.borisp.adventcode2023.day01;

import java.util.Optional;

class IsCalibrationDocumentValidImpl implements IsCalibrationDocumentValid {
    @Override
    public boolean test(CalibrationDocument calibrationDocument) {
        return Optional
                .ofNullable(calibrationDocument)
                .map(CalibrationDocument::content)
                .isPresent();
    }
}
