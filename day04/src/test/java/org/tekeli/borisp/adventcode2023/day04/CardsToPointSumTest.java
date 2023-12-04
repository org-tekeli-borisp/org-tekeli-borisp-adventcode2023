package org.tekeli.borisp.adventcode2023.day04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsToPointSumTest {


    @Test
    void shouldProduce18619WithInputData() throws URISyntaxException, IOException {
        final List<Card> cards = givenCardsFromInputFile("input.txt");

        final var points = cards
                .stream()
                .map(Card::points)
                .reduce(0L, Long::sum);

        assertThat(points).isEqualTo(18619L);
    }

    private List<Card> givenCardsFromInputFile(final String filename) throws URISyntaxException, IOException {
        final var path = Paths
                .get(Objects.requireNonNull(getClass().getClassLoader().getResource(filename))
                        .toURI());
        return Files
                .readAllLines(path)
                .stream()
                .map(this::lineToCard)
                .collect(Collectors.toList());
    }

    private Card lineToCard(final String line) {
        final var lineToCardId = new LineToCardIdImpl();
        final var lineToCardNumbers = new LineToCardNumbersImpl();

        final var cardId = lineToCardId.apply(line).orElse(null);
        final var cardNumbers = lineToCardNumbers.apply(line).orElse(null);

        if (Objects.nonNull(cardId) && Objects.nonNull(cardNumbers)) {
            return new Card(cardId, cardNumbers);
        } else {
            return null;
        }
    }
}
