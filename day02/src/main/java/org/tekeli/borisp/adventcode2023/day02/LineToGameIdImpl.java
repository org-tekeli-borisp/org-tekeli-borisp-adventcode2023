package org.tekeli.borisp.adventcode2023.day02;

import java.util.Optional;

class LineToGameIdImpl implements LineToGameId {
    @Override
    public Optional<Integer> apply(final String line) {
        try {
            final var gameIndexStart = line.indexOf("Game ");
            final var colonIndex = line.indexOf(":");
            final var substring = line.substring(gameIndexStart, colonIndex);
            final var stringNumber = substring.replace("Game ", "");
            return Optional.of(Integer.valueOf(stringNumber));
        } catch (NullPointerException | StringIndexOutOfBoundsException | NumberFormatException exception) {
            return Optional.empty();
        }
    }
}
