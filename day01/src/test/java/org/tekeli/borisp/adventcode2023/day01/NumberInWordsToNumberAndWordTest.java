package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class NumberInWordsToNumberAndWordTest {

    private NumberInWordsToNumberAndWord sus;

    @BeforeEach
    void setUp() {
        sus = new NumberInWordsToNumberAndWordImpl();
    }

    @Test
    void shouldConsumeCalibrationDocumentLinePart2() {
        final var givenNumberInWords = givenNumberInWords();

        assertThatNoException().isThrownBy(() -> sus.apply(givenNumberInWords));
    }

    @Test
    void shouldProduceCalibrationDocumentLine() {
        final var givenNumberInWords = givenNumberInWords();

        final var product = sus.apply(givenNumberInWords);

        assertThat(product).isInstanceOf(String.class);
    }

    @ParameterizedTest
    @CsvSource({
            "one, 1one",
            "two, 2two",
            "three, 3three",
            "four, 4four",
            "five, 5five",
            "six, 6six",
            "seven, 7seven",
            "eight, 8eight",
            "nine, 9nine"
    })
    void shouldReplaceWordWithNumberAndWord(final String input, final String expected) {
        final var givenNumberInWords = givenNumberInWords(input);

        final var product = sus.apply(givenNumberInWords);

        assertThat(product).isEqualTo(expected);
    }

    private String givenNumberInWords() {
        return givenNumberInWords("one2threeightbd");
    }

    private String givenNumberInWords(final String content) {
        return content;
    }
}
