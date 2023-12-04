package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LineToCardNumbersTest {

    private LineToCardNumbers sus;

    @BeforeEach
    void setUp() {
        sus = new LineToCardNumbersImpl();
    }

    @Test
    void shouldConsumeLine() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceOptionalOfCardNumbers() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        final var product = sus.apply(line);

        assertThat(product).containsInstanceOf(CardNumbers.class);
    }

    @Test
    void shouldProduceOptionalEmptyInCaseLineIsNull() {

        final var product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCardNumbersSubstringNotExists() {
        final var line = "Boom!";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCarNumbersSubstringIsEmpty() {
        final var line = "Card 1:";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCarNumbersSubstringIsBlank() {
        final var line = "Card 1: ";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCardNumbersSubstringWithoutSeparator() {
        final var line = "Card 1: 41 48 83 86 17";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCardNumbersSubstringWithoutWinningNumbers() {
        final var line = "Card 1: 41 48 83 86 17 | ";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalEmptyInCaseCardNumbersSubstringWithoutYourNumbers() {
        final var line = "Card 1: | 83 86  6 31 17 9 48 53";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalPresentOtherwise() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17 9 48 53";

        final var product = sus.apply(line);

        assertThat(product).isPresent();
    }

    @Test
    void shouldProduceWinningNumbers() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17 9 48 53";

        final var product = sus.apply(line);

        assertThat(product).isPresent();
        final var cardNumbers = product.get();
        assertThat(cardNumbers.winningNumbers()).containsExactly(41, 48, 83, 86, 17);
    }
    @Test
    void shouldProduceYourNumbers() {
        final var line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17 9 48 53";

        final var product = sus.apply(line);

        assertThat(product).isPresent();
        final var cardNumbers = product.get();
        assertThat(cardNumbers.yourNumbers()).containsExactly(83, 86, 6, 31, 17, 9, 48, 53);
    }
}
