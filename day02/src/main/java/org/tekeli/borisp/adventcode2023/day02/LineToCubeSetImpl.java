package org.tekeli.borisp.adventcode2023.day02;

import java.util.Objects;
import java.util.Optional;

class LineToCubeSetImpl implements LineToCubeSet {
    @Override
    public Optional<CubeSubset> apply(final String line) {
        if (Objects.isNull(line)) return Optional.empty();

        if (line.isBlank()) return Optional.of(new CubeSubset(0, 0, 0));

        final var cubeSets = line.split(",");

        int blues = 0;
        int greens = 0;
        int reds = 0;
        for (String cubeSetString : cubeSets) {
            if (cubeSetString.contains(" blue")) {
                blues = count(cubeSetString, " blue");
            }

            if (cubeSetString.contains(" green")) {
                greens = count(cubeSetString, " green");
            }

            if (cubeSetString.contains(" red")) {
                reds = count(cubeSetString, " red");
            }
        }

        return Optional.of(new CubeSubset(reds, greens, blues));
    }

    private int count(final String cubeSetString, final String color) {
        return Integer.parseInt(cubeSetString.replaceAll(color, "").trim());
    }
}
