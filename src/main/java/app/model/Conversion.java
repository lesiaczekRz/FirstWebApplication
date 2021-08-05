package app.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    /**
     * Zamienia String na Float
     * W przypadku nieprawidłowej konwersji zwraca null
     *
     * @param value {@link String}
     * @return Float|null
     */
    public static Float changeToFloat(String value) {
        float result;
        try {
            result = Float.parseFloat(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /**
     * Zamienia String na Date
     * W przypadku nieprawidłowej konwersji zwraca null
     *
     * @param value {@link String}
     * @return Date|null
     */
    public static Date changeToDate(String value) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }
}
