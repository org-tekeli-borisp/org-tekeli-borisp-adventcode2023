package org.tekeli.borisp.adventcode2023.day02;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineToCubeSetsImpl implements LineToCubeSets {
    @Override
    public List<CubeSubset> apply(final String line) {
        if(Objects.isNull(line)) return List.of();

        final var startIndex = line.indexOf(":");
        if(startIndex < 0) return List.of();

        final var cubeSetsSubstring = line.substring(startIndex + 1);
        if(cubeSetsSubstring.isBlank()) return List.of();

        final var cubeSetsString = cubeSetsSubstring.split(";");
        return Arrays.stream(cubeSetsString).map(this::toCubeSubset).collect(Collectors.toList());
    }

    private CubeSubset toCubeSubset(final String cubeSubsetString) {
        return new CubeSubset(0,0,0);
    }
}
