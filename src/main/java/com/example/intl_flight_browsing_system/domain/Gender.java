package com.example.intl_flight_browsing_system.domain;

public enum Gender {
    F("Female"), M("Male");

    private final String gender;

    Gender(String definition) {
        this.gender = definition;
    }

    public String getGender() {
        return gender;
    }
}
