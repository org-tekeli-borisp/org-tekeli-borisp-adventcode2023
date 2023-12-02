package org.tekeli.borisp.adventcode2023.day02;

import java.util.List;
import java.util.Optional;

public record Game(int id, List<CubeSubset> subsets) {
    public Integer powerOfMinimumSet() {
        Optional<Integer> minReds = subsets.stream().map(CubeSubset::reds).max(Integer::compareTo);
        Optional<Integer> minGreens = subsets.stream().map(CubeSubset::greens).max(Integer::compareTo);
        Optional<Integer> minBlues = subsets.stream().map(CubeSubset::blues).max(Integer::compareTo);

        return minReds.get() * minGreens.get() * minBlues.get();
    }
}
