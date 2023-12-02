package org.tekeli.borisp.adventcode2023.day02;

import java.util.List;
import java.util.Objects;

class GamesToSumImpl implements GamesToSum {
    private final IsGamePossible isGamePossible;

    GamesToSumImpl(final IsGamePossible isGamePossible) {
        this.isGamePossible = isGamePossible;
    }

    @Override
    public Integer apply(final List<Game> games,
                         final CubeBag cubeBag) {
        return areOK(games, cubeBag) ? calculateIdSum(games, cubeBag) : 0;
    }

    private Integer calculateIdSum(final List<Game> games,
                                   final CubeBag cubeBag) {
        return games
                .stream()
                .filter(game -> isGamePossible.test(game, cubeBag))
                .map(Game::id)
                .reduce(0, Integer::sum);
    }

    private boolean areOK(final List<Game> games,
                          final CubeBag cubeBag) {
        return Objects.nonNull(games) &&
                Objects.nonNull(cubeBag);
    }
}
