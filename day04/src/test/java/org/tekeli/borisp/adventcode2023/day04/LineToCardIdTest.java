package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LineToCardIdTest {

    private LineToCardId sus;

    @BeforeEach
    void setUp() {
        sus = new LineToCardIdImpl();
    }

    @Test
    void shouldConsumeString() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceOptionalOfInteger() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

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
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).isPresent();
    }

    @Test
    void shouldProduceGameWithIdFromLine() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        final Optional<Integer> product = sus.apply(line);

        assertThat(product).isPresent();
        final var id = product.get();
        assertThat(id).isEqualTo(1);
    }
}
