package org.tekeli.borisp.adventcode2023.day04;

import java.util.Optional;

public interface LineToCardNumbers {
    Optional<CardNumbers> apply(final String line);
}
