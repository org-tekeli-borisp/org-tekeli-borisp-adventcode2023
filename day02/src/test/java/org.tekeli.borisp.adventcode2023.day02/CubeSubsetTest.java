package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CubeSubsetTest {

    @Test
    void shouldHaveReds() {
        final var sus = givenCubeSet();

        assertThat(sus.reds()).isEqualTo(13);
    }

    @Test
    void shouldHaveGreens() {
        final var sus = givenCubeSet();

        assertThat(sus.greens()).isEqualTo(23);
    }

    @Test
    void shouldHaveBlues() {
        final var sus = givenCubeSet();

        assertThat(sus.blues()).isEqualTo(42);
    }

    private CubeSubset givenCubeSet() {
        return new CubeSubset(13, 23, 42);
    }
}
