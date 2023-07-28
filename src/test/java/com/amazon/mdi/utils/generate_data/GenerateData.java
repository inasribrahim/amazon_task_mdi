package com.amazon.mdi.utils.generate_data;

import com.github.javafaker.Faker;

public class GenerateData {
    private final Faker faker;

    public GenerateData() {
        this.faker = new Faker();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

}
