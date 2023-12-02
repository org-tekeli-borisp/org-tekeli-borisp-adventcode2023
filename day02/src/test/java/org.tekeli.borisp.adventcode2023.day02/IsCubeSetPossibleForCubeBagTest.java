package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class IsCubeSetPossibleForCubeBagTest {

    private IsCubeSetPossibleForCubeBag sus;

    @BeforeEach
    void setUp() {
        sus =  new IsCubeSetPossibleForCubeBagImpl();
    }

    @Test
    void shouldConsumeCubeSetAndCubeBag() {
        final var cubeSet = new CubeSubset(1,2,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        assertThatNoException().isThrownBy(() -> sus.test(cubeSet, cubeBag));
    }

    @Test
    void shouldProduceBoolean() {
        final var cubeSet = new CubeSubset(1,2,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isInstanceOf(Boolean.class);
    }

    @Test
    void shouldProduceFalseInCaseRedsInCubeBagLessThanRedsInCubeSubset() {
        final var cubeSet = new CubeSubset(11,2,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceTrueInCaseRedsInCubeBagMoreThanRedsInCubeSubset() {
        final var cubeSet = new CubeSubset(9,2,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }

    @Test
    void shouldProduceTrueInCaseRedsInCubeBagEqualRedsInCubeSubset() {
        final var cubeSet = new CubeSubset(10,2,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }

    @Test
    void shouldProduceFalseInCaseGreensInCubeBagLessThanGreensInCubeSubset() {
        final var cubeSet = new CubeSubset(1,13,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceTrueInCaseGreensInCubeBagMoreThanGreensInCubeSubset() {
        final var cubeSet = new CubeSubset(1,11,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }

    @Test
    void shouldProduceTrueInCaseGreensInCubeBagEqualGreensInCubeSubset() {
        final var cubeSet = new CubeSubset(1,12,3);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }

    @Test
    void shouldProduceFalseInCaseBluesInCubeBagLessThanBluesInCubeSubset() {
        final var cubeSet = new CubeSubset(1,2,14);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceTrueInCaseBluesInCubeBagMoreThanBluesInCubeSubset() {
        final var cubeSet = new CubeSubset(1,2,12);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }

    @Test
    void shouldProduceTrueInCaseBluesInCubeBagEqualBluesInCubeSubset() {
        final var cubeSet = new CubeSubset(1,2,13);
        final var cubeBag = new CubeBag(10, 12, 13);

        final var product = sus.test(cubeSet, cubeBag);

        assertThat(product).isTrue();
    }
}
