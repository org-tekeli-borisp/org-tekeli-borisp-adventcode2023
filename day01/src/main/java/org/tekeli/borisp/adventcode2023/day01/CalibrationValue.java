package org.tekeli.borisp.adventcode2023.day01;

import java.util.List;

public class CalibrationValue {

    private final List<Character> numbers;

    public CalibrationValue(final List<Character> numbers) {
        this.numbers = numbers;
    }

    public Integer getValue() {
        return switch(numbers.size()) {
            case 0 -> 0;
            case 1 -> constructValue(numbers.getFirst(), numbers.getFirst());
            default -> constructValue(numbers.getFirst(), numbers.getLast());
        };
    }

    private int constructValue(final Character first, final Character last) {
        return 10 * getInteger(first) + getInteger(last);
    }

    private Integer getInteger(final Character character) {
        return Integer.valueOf(character.toString());
    }
}
