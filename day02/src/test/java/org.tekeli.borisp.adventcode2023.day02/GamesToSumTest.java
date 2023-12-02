package org.tekeli.borisp.adventcode2023.day02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class GamesToSumTest {
    private GamesToSum sus;

    @BeforeEach
    void setUp() {
        sus = new GamesToSumImpl();
    }

    @Test
    void shouldConsumeListOfGames() {
        final List<Game> games = List.of(mock(Game.class));

        Assertions.assertThatNoException().isThrownBy(() -> sus.apply(games));
    }

    @Test
    void shouldProduceIntValue() {
        final List<Game> games = List.of(mock(Game.class));

        final var product = sus.apply(games);

        assertThat(product).isInstanceOf(Integer.class);
    }
}
