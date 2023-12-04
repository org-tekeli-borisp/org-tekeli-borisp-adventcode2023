package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    @Test
    void shouldHaveId() {

        final var sus = new Card(42, null);

        assertThat(sus.id()).isEqualTo(42);
    }

    @Test
    void shouldHaveCardNumbers() {
        final var carsNumbers = new CardNumbers(List.of(41, 48, 83, 86, 17), List.of(83, 86, 6, 31, 17, 9, 48, 53));

        final var sus = new Card(42, carsNumbers);

        assertThat(sus.points()).isEqualTo(8);
    }
}