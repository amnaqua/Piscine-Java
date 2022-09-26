package edu.school21;

import java.util.StringJoiner;

public class Car {
    private final Long number;
    private final String model;
    private Double price;
    private final Boolean reserved;

    public Car() {
        number = 0L;
        model = "default";
        price = 0.0;
        reserved = false;
    }

    public Car(Long number, String model, Double price, Boolean reserved) {
        this.number = number;
        this.model = model;
        this.price = price;
        this.reserved = reserved;
    }

    public float setSale(Double newPrice, float fix) {
        price = newPrice;
        return (fix);
    }

    @Override
    public String toString() {
        return (new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("number=" + number)
                .add("model='" + model + "'")
                .add("price=" + price)
                .add("reserved='" + reserved + "'")
                .toString());
    }
}
