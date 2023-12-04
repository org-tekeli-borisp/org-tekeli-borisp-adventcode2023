package org.tekeli.borisp.adventcode2023.day04;

import java.util.List;

public record CardNumbers(List<Integer> winningNumbers, List<Integer> yourNumbers) {
    public long points() {
        return (long) Math.pow(2, winningMatchCount() -1);
    }

    public long matches() {
        return winningMatchCount();
    }

    private long winningMatchCount() {
        return yourNumbers
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
