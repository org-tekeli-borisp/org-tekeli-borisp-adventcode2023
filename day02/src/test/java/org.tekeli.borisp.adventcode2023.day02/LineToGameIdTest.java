package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LineToGameIdTest {

    private LineToGameId sus;

    @BeforeEach
    void setUp() {
        sus = new LineToGameIdImpl();
    }

    @Test
    void shouldConsumeString() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceOptionalOfInteger() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).containsInstanceOf(Integer.class);
    }

    @Test
    void shouldProduceOptionalEmptyInCaseLineIsNull() {

        final Optional<Integer> product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseGameIdExtractionFailed() {
        final var line = "Boom!";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalPresentOtherwise() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).isPresent();
    }

    @Test
    void shouldProduceGameWithIdFromLine() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).isPresent();
        final var id = product.get();
        assertThat(id).isEqualTo(1);
    }
}
