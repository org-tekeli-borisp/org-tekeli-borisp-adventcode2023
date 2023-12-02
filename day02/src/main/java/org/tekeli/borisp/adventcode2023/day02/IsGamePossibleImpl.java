package org.tekeli.borisp.adventcode2023.day02;

import java.util.Objects;

class IsGamePossibleImpl implements IsGamePossible {

    private final IsCubeSetPossibleForCubeBag isCubeSetPossibleForCubeBag;

    public IsGamePossibleImpl(final IsCubeSetPossibleForCubeBag isCubeSetPossibleForCubeBag) {
        this.isCubeSetPossibleForCubeBag = isCubeSetPossibleForCubeBag;
    }

    @Override
    public boolean test(final Game game, final CubeBag cubeBag) {
        return isGameOK(game) &&
                isCubeBagOk(cubeBag) &&
                hasOnlyPossibleCubeSets(game, cubeBag);

    }

    private boolean isGameOK(final Game game) {
        return Objects.nonNull(game) &&
                Objects.nonNull(game.subsets()) &&
                !game.subsets().isEmpty();
    }

    private boolean isCubeBagOk(final CubeBag cubeBag) {
        return Objects.nonNull(cubeBag);
    }

    private boolean hasOnlyPossibleCubeSets(final Game game, final CubeBag cubeBag) {
        return game
                .subsets()
                .stream().
                allMatch(cubeSet -> isCubeSetPossibleForCubeBag.test(cubeSet, cubeBag));
    }
}
