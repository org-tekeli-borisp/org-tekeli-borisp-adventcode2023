package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LineToCubeSetsTest {

    private LineToCubeSets sus;

    @BeforeEach
    void setUp() {
        sus = new LineToCubeSetsImpl(new LineToCubeSetImpl());
    }

    @Test
    void shouldConsumeLine() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceListOfCubeSets() {
        final var line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        final var product = sus.apply(line);

        assertThat(product).hasOnlyElementsOfType(CubeSubset.class);
    }

    @Test
    void shouldProduceEmptyListInCaseLineIsNull() {

        final var product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceEmptyListInCaseCubeSubsetsSubstringNotExists() {
        final var line = "Boom!";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceEmptyListInCaseCubeSubsetsSubstringIsEmpty() {
        final var line = "Game 1:";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceEmptyListInCaseCubeSubsetsSubstringIsBlank() {
        final var line = "Game 1: ";

        final var product = sus.apply(line);

        assertThat(product).isEmpty();
    }


    @Test
    void shouldProduceListWithOneCubeSubsetInCaseOnlyOneCubeSubset() {
        final var line = "Game 1: 3 red";

        final var product = sus.apply(line);

        assertThat(product).hasSize(1);
    }


    @Test
    void shouldProduceListWithOneCubeSubsetInCaseCubeSubsetsSubstringHasASemicolon() {
        final var line = "Game 1: ;";

        final var product = sus.apply(line);

        assertThat(product).hasSize(1);
    }

    @Test
    void shouldProduceListWithTwoCubeSubsetInCaseCubeSubsetsSubstringHasTwoCubeSubsets() {
        final var line = "Game 1: 3 red; 2 green";

        final var product = sus.apply(line);

        assertThat(product).hasSize(2);
    }
}
