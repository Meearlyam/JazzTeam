package by.meearlyam.jazzteam.model;

/**
 * Default number to string converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class DefaultNumberToStringConverter extends AbstractNumberToStringConverter {

    private static final String MINUS = "минус";
    private static final String ZERO = "ноль";
    private static final Scale SCALE = new Scale();
    private AbstractNumberToStringConverter converter = new CompositeNumberToStringConverter(63);

    @Override
    public String getName(String value) {
        boolean negative = false;
        if (value.startsWith("-")) {
            negative = true;
            value = value.substring(1);
        }

        int decimals = value.indexOf('.');
        String decimalValue = null;
        if (0 <= decimals) {
            decimalValue = value.substring(decimals + 1);
            value = value.substring(0, decimals);
        }

        String name = converter.getName(value);

        if ("".equals(name)) {
            name = ZERO;
        } else {
            if (negative) {
                name = MINUS.concat(SEPARATOR).concat(name);
            }
        }

        if (!(null == decimalValue || "".equals(decimalValue))) {

            String zeroDecimalValue = "";
            for (int i = 0; i < decimalValue.length(); i++) {
                zeroDecimalValue = zeroDecimalValue.concat("0");
            }
            name = name.concat(SEPARATOR).concat(" и ").concat(SEPARATOR);
            if (decimalValue.equals(zeroDecimalValue)) {
                name = name.concat(
                        ZERO).concat(SEPARATOR).concat(
                        SCALE.getName(-decimalValue.length()));
            } else {
                name = name.concat(
                        converter.getName(decimalValue)).concat(SEPARATOR).concat(
                        SCALE.getName(-decimalValue.length()));
            }

        }

        return name;
    }
}
