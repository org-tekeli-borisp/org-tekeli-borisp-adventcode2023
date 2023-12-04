package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

class CardsToScratchCardsSumTest implements CardsFromInputFileLoader {

    @Test
    void shouldProduce18619WithInputData() throws URISyntaxException, IOException {
        final var cards = givenCardsFromInputFile("input.txt");

        final var points = cards
                .stream()
                .map(Card::points)
                .reduce(0L, Long::sum);

        assertThat(points).isEqualTo(18619L);
    }

}
