package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void shouldHaveId() {

        final var sus = new Game(42, List.of());

        assertThat(sus.id()).isEqualTo(42);
    }

    @Test
    void shouldHaveGameSubsets() {
        final var cubeSubset = new CubeSubset(1, 2, 3);

        final var sus = new Game(42 ,List.of(cubeSubset));

        assertThat(sus.subsets()).isInstanceOf(List.class);
        assertThat(sus.subsets()).hasOnlyElementsOfType(CubeSubset.class);
        assertThat(sus.subsets()).contains(cubeSubset);
    }

    @Test
    void mayContainMultipleGameSubsets() {
        final var cubeSubset = new CubeSubset(1, 2, 3);
        final var cubeSubset2 = new CubeSubset(4, 5, 6);
        final var cubeSubset3 = new CubeSubset(7, 8, 9);

        final var sus = new Game(42 ,List.of(cubeSubset, cubeSubset2, cubeSubset3));

        assertThat(sus.subsets()).contains(cubeSubset, cubeSubset2, cubeSubset3);
    }
}