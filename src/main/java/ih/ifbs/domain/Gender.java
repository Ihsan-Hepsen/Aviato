package ih.ifbs.domain;

public enum Gender {
    F("Female"), M("Male");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
