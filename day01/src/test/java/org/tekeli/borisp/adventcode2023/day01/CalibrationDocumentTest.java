package org.tekeli.borisp.adventcode2023.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalibrationDocumentTest {

    private CalibrationDocument sus;

    @BeforeEach
    void setUp() {
        sus = new CalibrationDocument("""
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """);
    }

    @Test
    void shouldContainText() {
        assertThat(sus.content()).isInstanceOf(String.class);
    }
}