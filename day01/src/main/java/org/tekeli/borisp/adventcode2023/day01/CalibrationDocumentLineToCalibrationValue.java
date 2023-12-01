package org.tekeli.borisp.adventcode2023.day01;

public interface CalibrationDocumentLineToCalibrationValue {


    CalibrationValue apply(final String calibrationDocumentLine);
}
