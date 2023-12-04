package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    @Test
    void shouldHaveId() {

        final var sus = new Card(42, List.of(), List.of());

        assertThat(sus.id()).isEqualTo(42);
    }

    @Test
    void shouldHaveWinningNumbers() {
        final var winningNumbers = List.of(1,2,3);

        final var sus = new Card(42, winningNumbers, List.of());

        assertThat(sus.winningNumbers()).isInstanceOf(List.class);
        assertThat(sus.winningNumbers()).hasOnlyElementsOfType(Integer.class);
        assertThat(sus.winningNumbers()).isEqualTo(winningNumbers);
    }

    @Test
    void shouldHaveNumbers() {
        final var numbers = List.of(1,4,6,7);

        final var sus = new Card(42,  List.of(), numbers);

        assertThat(sus.numbers()).isInstanceOf(List.class);
        assertThat(sus.numbers()).hasOnlyElementsOfType(Integer.class);
        assertThat(sus.numbers()).isEqualTo(numbers);
    }
}