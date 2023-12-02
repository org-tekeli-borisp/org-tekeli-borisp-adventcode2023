package org.tekeli.borisp.adventcode2023.day02;

import java.util.Optional;

public interface LineToGame {
    Optional<Game> apply(final String line);
}
