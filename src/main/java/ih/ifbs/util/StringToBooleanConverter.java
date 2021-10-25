package ih.ifbs.util;

import org.springframework.core.convert.converter.Converter;

public class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String str) {
        if (str.equals("1")) return true;
        if (str.equals("0")) return false;
        return true; // default
    }
}
