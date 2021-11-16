package ih.ifbs.domain;

import ih.ifbs.util.LookupUtil;

public enum FlightType {
    COMM("Commercial"), PRIV("Private");

    private final String value;

    FlightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static public FlightType lookup(String id) {
        return LookupUtil.lookup(FlightType.class, id);
    }
}
