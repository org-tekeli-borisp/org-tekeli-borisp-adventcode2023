package org.tekeli.borisp.adventcode2023.day02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class GamesToSumTest {
    private GamesToSum sus;

    @BeforeEach
    void setUp() {
        sus = new GamesToSumImpl(new IsGamePossibleImpl(new IsCubeSetPossibleForCubeBagImpl()));
    }

    @Test
    void shouldConsumeListOfGamesAndCubeBag() {
        final var games = List.of(mock(Game.class));
        final var cubeBag = mock(CubeBag.class);

        Assertions.assertThatNoException().isThrownBy(() -> sus.apply(games, cubeBag));
    }

    @Test
    void shouldProduceIntValue() {
        final List<Game> games = List.of(mock(Game.class));
        final var cubeBag = mock(CubeBag.class);

        final var product = sus.apply(games, cubeBag);

        assertThat(product).isInstanceOf(Integer.class);
    }


    @Test
    void shouldProduceZeroInCaseGamesAndCubeBagAreNull() {

        final var product = sus.apply(null, null);

        assertThat(product).isZero();
    }

    @Test
    void shouldProduceZeroInCaseGamesIsNull() {
        final var cubeBag = mock(CubeBag.class);

        final var product = sus.apply(null, cubeBag);

        assertThat(product).isZero();
    }

    @Test
    void shouldProduceZeroInCaseCubeBagIsNull() {
        final var games = List.of(mock(Game.class));

        final var product = sus.apply(games, null);

        assertThat(product).isZero();
    }

    @Test
    void shouldProduceIntValueForExampleData() {
        final var games = givenExampleGames();
        final var cubeBag = new CubeBag(12, 13, 14);

        final var product = sus.apply(games, cubeBag);

        assertThat(product).isEqualTo(8);
    }

    @Test
    void shouldProduce8WithExampleData() throws URISyntaxException, IOException {
        final var games = givenGamesFromInputFile("example.txt");
        final var cubeBag = new CubeBag(12, 13, 14);

        final var product = sus.apply(games, cubeBag);

        assertThat(product).isEqualTo(8);
    }

    @Test
    void shouldProduce2447WithInputData() throws URISyntaxException, IOException {
        final var games = givenGamesFromInputFile("input.txt");
        final var cubeBag = new CubeBag(12, 13, 14);

        final var product = sus.apply(games, cubeBag);

        assertThat(product).isEqualTo(2447);
    }


    private static List<Game> givenExampleGames() {
        return List.of(
                new Game(1, List.of(
                        new CubeSubset(4, 0, 3),
                        new CubeSubset(1, 2, 6),
                        new CubeSubset(0, 2, 0))
                ),
                new Game(2, List.of(
                        new CubeSubset(0, 2, 1),
                        new CubeSubset(1, 3, 4),
                        new CubeSubset(0, 1, 1))
                ),
                new Game(3, List.of(
                        new CubeSubset(20, 3, 6),
                        new CubeSubset(4, 13, 5),
                        new CubeSubset(1, 5, 0))
                ),
                new Game(4, List.of(
                        new CubeSubset(3, 1, 6),
                        new CubeSubset(6, 3, 5),
                        new CubeSubset(14, 0, 15))
                ),
                new Game(5, List.of(
                        new CubeSubset(6, 3, 1),
                        new CubeSubset(1, 2, 2)
                ))
        );
    }

    private List<Game> givenGamesFromInputFile(final String filename) throws URISyntaxException, IOException {
        final var lineToGame = new LineToGameImpl(new LineToGameIdImpl(), new LineToCubeSetsImpl(new LineToCubeSetImpl()));

        final var path = Paths
                .get(Objects.requireNonNull(getClass().getClassLoader().getResource(filename))
                        .toURI());
        return Files
                .readAllLines(path)
                .stream()
                .map(lineToGame::apply)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
