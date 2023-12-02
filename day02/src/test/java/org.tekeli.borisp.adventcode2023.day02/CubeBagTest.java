package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CubeBagTest {

    @Test
    void shouldHaveReds() {
        final var sus  = givenCubeBag();

        assertThat(sus.reds()).isEqualTo(14);
    }

    @Test
    void shouldHaveGreens() {
        final var sus  = givenCubeBag();

        assertThat(sus.greens()).isEqualTo(21);
    }

    @Test
    void shouldHaveBlues() {
        final var sus  = givenCubeBag();

        assertThat(sus.blues()).isEqualTo(47);
    }

    private CubeBag givenCubeBag() {
        return new CubeBag(14, 21, 47);
    }
}
