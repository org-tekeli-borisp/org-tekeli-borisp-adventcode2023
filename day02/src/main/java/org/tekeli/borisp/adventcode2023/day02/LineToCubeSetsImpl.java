package org.tekeli.borisp.adventcode2023.day02;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LineToCubeSetsImpl implements LineToCubeSets {

    private final LineToCubeSet lineToCubeSet;

    public LineToCubeSetsImpl(LineToCubeSet lineToCubeSet) {
        this.lineToCubeSet = lineToCubeSet;
    }

    @Override
    public List<CubeSubset> apply(final String line) {
        if (Objects.isNull(line)) return List.of();

        final var startIndex = line.indexOf(":");
        if (startIndex < 0) return List.of();

        final var cubeSetsSubstring = line.substring(startIndex + 1);
        if (cubeSetsSubstring.isBlank()) return List.of();

        final var cubeSetsString = cubeSetsSubstring.split(";");
        return Arrays
                .stream(cubeSetsString)
                .map(lineToCubeSet::apply)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
