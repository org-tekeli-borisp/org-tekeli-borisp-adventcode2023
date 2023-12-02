package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class IsCubeSetPossibleForCubeBagTest {

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
}
