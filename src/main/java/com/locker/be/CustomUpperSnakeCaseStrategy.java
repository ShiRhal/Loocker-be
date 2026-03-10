package com.locker.be;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

public class CustomUpperSnakeCaseStrategy extends PropertyNamingStrategies.NamingBase {
    @Override
    public String translate(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String snake = input
                .replaceAll("([a-z0-9])([A-Z])", "$1_$2")
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2");

        return snake.toUpperCase();
    }
}