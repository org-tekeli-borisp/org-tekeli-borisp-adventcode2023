package org.tekeli.borisp.adventcode2023.day01;

import java.util.Optional;

public interface Calibration {
    Optional<CalibrationSum> apply(final CalibrationDocument calibrationDocument);
}
