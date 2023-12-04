package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsToPointSumTest implements  CardsFromInputFileLoader {
    @Test
    void shouldProduce18619WithInputData() throws URISyntaxException, IOException {
        final List<Card> cards = givenCardsFromInputFile("input.txt");

        final var points = cards
                .stream()
                .map(Card::points)
                .reduce(0L, Long::sum);

        assertThat(points).isEqualTo(18619L);
    }
}
