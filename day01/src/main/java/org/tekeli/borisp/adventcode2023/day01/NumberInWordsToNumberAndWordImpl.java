package org.tekeli.borisp.adventcode2023.day01;

class NumberInWordsToNumberAndWordImpl implements NumberInWordsToNumberAndWord {
    @Override
    public String apply(final String calibrationDocumentLine) {
        return calibrationDocumentLine
                .replaceAll("one", "1one")
                .replaceAll("two", "2two")
                .replaceAll("three", "3three")
                .replaceAll("four", "4four")
                .replaceAll("five", "5five")
                .replaceAll("six", "6six")
                .replaceAll("seven", "7seven")
                .replaceAll("eight", "8eight")
                .replaceAll("nine", "9nine");
    }
}
