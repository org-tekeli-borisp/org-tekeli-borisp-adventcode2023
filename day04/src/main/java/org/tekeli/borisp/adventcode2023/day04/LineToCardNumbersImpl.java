package org.tekeli.borisp.adventcode2023.day04;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

class LineToCardNumbersImpl implements LineToCardNumbers {


    @Override
    public  Optional<CardNumbers> apply(final String line) {
        if (Objects.isNull(line)) return Optional.empty();

        final var startIndex = line.indexOf(":");
        if (startIndex < 0) return Optional.empty();

        final var cardNumbersString = line.substring(startIndex + 1);
        if (cardNumbersString.isBlank()) return Optional.empty();

        final var cardNumbers = cardNumbersString.split("\\|");
        if(cardNumbers.length != 2) return Optional.empty();

        final var winningNumbers = getList(cardNumbers, 0);
        final var yourNumbers = getList(cardNumbers, 1);

        if(winningNumbers.isEmpty() || yourNumbers.isEmpty()) return Optional.empty();

        return Optional.of(new CardNumbers(winningNumbers,yourNumbers));
    }

    private static List<Integer> getList(final String[] cardNumbers, final int position) {
        return Arrays.stream(cardNumbers[position].split(" "))
                .filter(not(String::isBlank))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
