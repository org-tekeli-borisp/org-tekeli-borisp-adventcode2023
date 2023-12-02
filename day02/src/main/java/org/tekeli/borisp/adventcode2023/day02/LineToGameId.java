package org.tekeli.borisp.adventcode2023.day02;

import java.util.Optional;

public interface LineToGameId {

    Optional<Integer> apply(final String line);
}
