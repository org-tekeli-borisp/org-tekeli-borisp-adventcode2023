package org.tekeli.borisp.adventcode2023.day02;

public class IsCubeSetPossibleForCubeBagImpl implements IsCubeSetPossibleForCubeBag {
    @Override
    public boolean test(final CubeSubset cubeSet, final CubeBag cubeBag) {
        return areRedsPossible(cubeSet, cubeBag) &&
                areGreensPossible(cubeSet, cubeBag) &&
                areBluesPossible(cubeSet, cubeBag);
    }

    private boolean areRedsPossible(final CubeSubset cubeSet, final CubeBag cubeBag) {
        return cubeBag.reds() >= cubeSet.reds();
    }

    private boolean areGreensPossible(final CubeSubset cubeSet, final CubeBag cubeBag) {
        return cubeBag.greens() >= cubeSet.greens();
    }

    private boolean areBluesPossible(final CubeSubset cubeSet, final CubeBag cubeBag) {
        return cubeBag.blues() >= cubeSet.blues();
    }
}
