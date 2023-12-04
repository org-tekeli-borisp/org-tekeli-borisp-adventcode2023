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
    void shouldHaveYourNumbers() {
        final var yourNumbers = List.of(1, 4, 6, 7);

        final var sus = new CardNumbers(List.of(), yourNumbers);

        assertThat(sus.yourNumbers()).isInstanceOf(List.class);
        assertThat(sus.yourNumbers()).hasOnlyElementsOfType(Integer.class);
        assertThat(sus.yourNumbers()).isEqualTo(yourNumbers);
    }

    @Test
    void shouldProducePoints() {
        final var winningNumbers = List.of(41, 48, 83, 86, 17);
        final var yourNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);

        final var sus = new CardNumbers(winningNumbers, yourNumbers);

        assertThat(sus.points()).isEqualTo(8);
    }

    @Test
    void shouldProduceMatches() {
        final var winningNumbers = List.of(41, 48, 83, 86, 17);
        final var yourNumbers = List.of(83, 86, 6, 31, 17, 9, 48, 53);

        final var sus = new CardNumbers(winningNumbers, yourNumbers);

        assertThat(sus.matches()).isEqualTo(4);
    }
}