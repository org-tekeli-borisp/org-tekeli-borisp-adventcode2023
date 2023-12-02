package org.tekeli.borisp.adventcode2023.day02;

import java.util.Optional;

public interface LineToCubeSet {
    Optional<CubeSubset> apply(final String line);
}
