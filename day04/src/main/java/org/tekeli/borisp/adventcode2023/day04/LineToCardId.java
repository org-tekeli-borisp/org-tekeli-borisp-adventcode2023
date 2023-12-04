package org.tekeli.borisp.adventcode2023.day04;

import java.util.Optional;

public interface LineToCardId {

    Optional<Integer> apply(final String line);
}
