package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardNumbersTest {

    @Test
    void shouldHaveWinningNumbers() {
        final var winningNumbers = List.of(1, 2, 3);

        final var sus = new CardNumbers(winningNumbers, List.of());

        assertThat(sus.winningNumbers()).isInstanceOf(List.class);
        assertThat(sus.winningNumbers()).hasOnlyElementsOfType(Integer.class);
        assertThat(sus.winningNumbers()).isEqualTo(winningNumbers);
    }

    @Test
    void shouldHaveNumbers() {
        final var numbers = List.of(1, 4, 6, 7);

        final var sus = new CardNumbers(List.of(), numbers);

        assertThat(sus.yourNumbers()).isInstanceOf(List.class);
        assertThat(sus.yourNumbers()).hasOnlyElementsOfType(Integer.class);
        assertThat(sus.yourNumbers()).isEqualTo(numbers);
    }
}