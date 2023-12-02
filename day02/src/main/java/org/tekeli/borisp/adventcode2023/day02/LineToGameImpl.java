package org.tekeli.borisp.adventcode2023.day02;

import java.util.Objects;
import java.util.Optional;

class LineToGameImpl implements LineToGame {

    private final LineToGameId lineToGameId;
    private final LineToCubeSets lineToCubeSets;

    public LineToGameImpl(final LineToGameIdImpl lineToGameId, LineToCubeSets lineToCubeSets) {
        this.lineToGameId = lineToGameId;
        this.lineToCubeSets = lineToCubeSets;
    }

    @Override
    public Optional<Game> apply(final String line) {
        if(Objects.isNull(line)) return Optional.empty();
        final var optionalGameId = lineToGameId.apply(line);
        if(optionalGameId.isEmpty()) return Optional.empty();
        final var cubeSeSubsets = lineToCubeSets.apply(line);
        return Optional.of(new Game(optionalGameId.get(), cubeSeSubsets));
    }
}
