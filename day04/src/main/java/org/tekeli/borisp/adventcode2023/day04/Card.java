package org.tekeli.borisp.adventcode2023.day04;

public record Card(int id, CardNumbers cardNumbers) {
    public long points() {
        return cardNumbers.points();
    }
}
