package org.tekeli.borisp.adventcode2023.day04;

import java.util.Optional;

class LineToCardIdImpl implements LineToCardId {
    @Override
    public Optional<Integer> apply(final String line) {
        try {
            final var gameIndexStart = line.indexOf("Card ");
            final var colonIndex = line.indexOf(":");
            final var substring = line.substring(gameIndexStart, colonIndex);
            final var stringNumber = substring.replace("Card ", "");
            return Optional.of(Integer.valueOf(stringNumber));
        } catch (NullPointerException | StringIndexOutOfBoundsException | NumberFormatException exception) {
            return Optional.empty();
        }
    }
}
