package ih.ifbs.domain;

import ih.ifbs.util.LookupUtil;

public enum Gender {
    F("Female"), M("Male");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    static public Gender lookup(String id) {
        return LookupUtil.lookup(Gender.class, id);
    }
}
