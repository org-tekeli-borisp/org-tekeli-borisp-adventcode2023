package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CardsToScratchCardsSumTest implements CardsFromInputFileLoader {

    private CardsToScratchCardsSum sus;

    @BeforeEach
    void setUp() {
        sus = new CardsToScratchCardsSumImpl();
    }

    @Test
    void shouldConsumeListOfCards() {
        final var cards = List.of(new Card(1, new CardNumbers(List.of(41, 48, 83, 86, 17), List.of(83, 86,  6, 31, 17,  9, 48, 53))));

        assertThatNoException().isThrownBy(() -> sus.apply(cards));
    }

    @Test
    void shouldProduceScratchCardsSum() {
        final var cards = List.of(new Card(1, new CardNumbers(List.of(41, 48, 83, 86, 17), List.of(83, 86,  6, 31, 17,  9, 48, 53))));

        final var product = sus.apply(cards);

        assertThat(product).isInstanceOf(Long.class);
    }
}
