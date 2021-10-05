package ih.ifbs.domain;

public enum FlightType {
    COMM("Commercial"), PRIV("Private");

    private final String value;

    FlightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
