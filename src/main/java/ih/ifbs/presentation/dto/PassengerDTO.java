package ih.ifbs.presentation.dto;

import ih.ifbs.domain.Gender;

public class PassengerDTO {

    private String name;
    private int age;
    private Gender gender;
    private boolean isTransitPassenger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isTransitPassenger() {
        return isTransitPassenger;
    }

    public void setTransitPassenger(boolean isTransit) {
        isTransitPassenger = isTransit;
    }
}