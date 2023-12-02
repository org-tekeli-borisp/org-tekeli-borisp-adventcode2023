package org.tekeli.borisp.adventcode2023.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LineToCubeSetTest {

    private LineToCubeSet sus;

    @BeforeEach
    void setUp() {
        sus = new LineToCubeSetImpl();
    }

    @Test
    void shouldConsumeLine() {
        final var line = "3 blue, 4 red, 4 green";

        assertThatNoException().isThrownBy(() -> sus.apply(line));
    }

    @Test
    void shouldProduceOptionalOfCubeSet() {
        final var line = "3 blue, 4 red, 4 green";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).containsInstanceOf(CubeSubset.class);
    }

    @Test
    void shouldProduceOptionalEmptyInCaseLineIsNull() {

        final Optional<CubeSubset> product = sus.apply(null);

        assertThat(product).isEmpty();
    }

    @Test
    void shouldProduceOptionalPresentOtherwise() {
        final var line = "3 blue, 4 red, 5 green";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
    }

    @Test
    void shouldProduceCubeSubsetWithZerosInCaseLineIsEmpty() {
        final var line = "";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.reds()).isEqualTo(0);
        assertThat(cubeSubset.greens()).isEqualTo(0);
        assertThat(cubeSubset.blues()).isEqualTo(0);
    }

    @Test
    void shouldProduceCubeSubsetWithBlues() {
        final var line = "43 blue";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.blues()).isEqualTo(43);
    }

    @Test
    void shouldProduceCubeSubsetWithGreens() {
        final var line = "43 green";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.greens()).isEqualTo(43);
    }

    @Test
    void shouldProduceCubeSubsetWithReds() {
        final var line = "43 red";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.reds()).isEqualTo(43);
    }

    @Test
    void shouldProduceCubeSubsetWithTwo() {
        final var line = "43 red, 43 green";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.reds()).isEqualTo(43);
        assertThat(cubeSubset.greens()).isEqualTo(43);
        assertThat(cubeSubset.blues()).isEqualTo(0);
    }

    @Test
    void shouldProduceCubeSubsetWithAllThree() {
        final var line = "43 red, 43 green, 43 blue";

        final Optional<CubeSubset> product = sus.apply(line);

        assertThat(product).isPresent();
        final var cubeSubset = product.get();
        assertThat(cubeSubset.reds()).isEqualTo(43);
        assertThat(cubeSubset.greens()).isEqualTo(43);
        assertThat(cubeSubset.blues()).isEqualTo(43);
    }
}
