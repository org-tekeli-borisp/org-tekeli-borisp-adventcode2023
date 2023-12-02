package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.mockito.Mockito.mock;

class IsGamePossibleTest {

    private IsGamePossible sus;

    @BeforeEach
    void setUp() {
        sus = new IsGamePossibleImpl(new IsCubeSetPossibleForCubeBagImpl());
    }

    @Test
    void shouldConsumeGameAndCubeBag() {
        final var game = mock(Game.class);
        final var cubeBag = mock(CubeBag.class);

        assertThatNoException().isThrownBy(() -> sus.test(game, cubeBag));
    }

    @Test
    void shouldProduceBoolean() {
        final var game = mock(Game.class);
        final var cubeBag = mock(CubeBag.class);

        final var product  =  sus.test(game, cubeBag);

        assertThat(product).isInstanceOf(Boolean.class);
    }

    @Test
    void shouldProduceFalseInCaseGameAndCubeBagIsNull() {

        final var product  =  sus.test(null, null);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseInCaseGameIsNull() {
        final var cubeBag = mock(CubeBag.class);

        final var product  =  sus.test(null, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseInCaseCubeBagIsNull() {
        final var game = mock(Game.class);

        final var product  =  sus.test(game, null);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseInCaseGameWithoutSubsets() {
        final var game = new Game(1, null);
        final var cubeBag = new CubeBag(10, 11, 12);

        final var product  =  sus.test(game, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseInCaseGameWithoutEmptySubsets() {
        final var game = new Game(1, List.of());
        final var cubeBag = new CubeBag(10, 11, 12);

        final var product  =  sus.test(game, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceFalseInCaseGameContainsImpossibleSubset() {
        final var game = new Game(1, List.of(new CubeSubset(11, 12, 13)));
        final var cubeBag = new CubeBag(10, 11, 12);

        final var product  =  sus.test(game, cubeBag);

        assertThat(product).isFalse();
    }

    @Test
    void shouldProduceTrueOtherwise() {
        final var game = new Game(1, List.of(new CubeSubset(1, 1, 1)));
        final var cubeBag = new CubeBag(10, 11, 12);

        final var product  =  sus.test(game, cubeBag);

        assertThat(product).isTrue();
    }
}
