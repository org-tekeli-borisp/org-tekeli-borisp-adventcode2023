package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void shouldHaveId() {

        final var sus = new Game(42);

        assertThat(sus.id()).isEqualTo(42);
    }
}