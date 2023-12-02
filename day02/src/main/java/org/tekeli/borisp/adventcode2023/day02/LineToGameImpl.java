package org.tekeli.borisp.adventcode2023.day02;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

class LineToGameImpl implements LineToGame {

    private final LineToGameId lineToGameId;

    public LineToGameImpl(final LineToGameIdImpl lineToGameId) {
        this.lineToGameId = lineToGameId;
    }

    @Override
    public Optional<Game> apply(final String line) {
        if(Objects.isNull(line)) return Optional.empty();
        final var optionalGameId = lineToGameId.apply(line);
        if(optionalGameId.isEmpty()) return Optional.empty();
        return Optional.of(new Game(1, List.of(new CubeSubset(1,2,3))));
    }
}
