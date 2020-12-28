package by.meearlyam.jazzteam.model;

/**
 * Tens converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class TensConverter extends AbstractNumberToStringConverter {

    private static final String[] TOKENS = new String[]{"двадцать", "тридцать", "сорок",
            "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    private UnitsConverter unitsConverter = new UnitsConverter();

    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        boolean tensFound = false;

        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }

        number %= 100;

        if (number >= 20) {
            buffer.append(TOKENS[(number / 10) - 2]);
            number %= 10;
            tensFound = true;
            // numbers 20-99
        }

        if (number != 0) {
            if (tensFound) {
                buffer.append(SEPARATOR);
            }
            buffer.append(unitsConverter.getName(number));
        }
        return buffer.toString();
    }
}
