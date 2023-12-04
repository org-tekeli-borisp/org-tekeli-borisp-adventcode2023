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
        final var carsNumbers = new CardNumbers(List.of(1,2,3), List.of(1,4,6,7));

        final var sus = new Card(42, carsNumbers);

        assertThat(sus.cardNumbers()).isInstanceOf(CardNumbers.class);
        assertThat(sus.cardNumbers()).isEqualTo(carsNumbers);
    }
}