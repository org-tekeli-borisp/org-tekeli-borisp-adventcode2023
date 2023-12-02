package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LineToGameTest {

    private LineToGame sus;

    @BeforeEach
    void setUp() {
        sus = new LineToGameImpl(new LineToGameIdImpl());
    }

    @Test
    void shouldConsumeString() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceOptionalOfGame() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final Optional<Game> product = sus.apply(line);

        assertThat(product).containsInstanceOf(Game.class);
    }

    @Test
    void shouldReturnOptionalEmptyInCaseLineIsNull() {

        final Optional<Game> product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldReturnOptionalEmptyInCaseGameIdExtractionFailed() {
        final var line = "Boom!";

        final Optional<Game> product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldReturnOptionalPresentOtherwiseWithGameIdOne() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final Optional<Game> product = sus.apply(line);

        assertThat(product).isPresent();
        final var game = product.get();
        assertThat(game.id()).isEqualTo(1);
    }
}
