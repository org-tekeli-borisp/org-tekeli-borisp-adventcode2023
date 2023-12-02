package org.tekeli.borisp.adventcode2023.day02;

import java.util.List;
import java.util.Objects;

class GamesToPowerOfMinimumSetsSumImpl implements GamesToPowerOfMinimumSetsSum {

    @Override
    public Integer apply(final List<Game> games) {
        return isOk(games) ? calculatePowerOfMinimumSetsSum(games) : 0;
    }

    private Integer calculatePowerOfMinimumSetsSum(final List<Game> games) {
        return games
                .stream()
                .map(Game::powerOfMinimumSet)
                .reduce(0, Integer::sum);
    }

    private boolean isOk(final List<Game> games) {
        return Objects.nonNull(games);
    }
}
