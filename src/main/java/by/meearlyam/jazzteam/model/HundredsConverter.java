package by.meearlyam.jazzteam.model;

/**
 * Hundreds converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class HundredsConverter extends AbstractNumberToStringConverter {

    private static final String[] TOKENS = new String[]{"сто", "двести", "триста",
            "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    private TensConverter tensConverter = new TensConverter();

    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        boolean tensFound = false;

        int number;

        if (value.length() > 4) {
            number = Integer.valueOf(value.substring(value.length() - 4), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }

        number %= 1000;

        if (number >= 100) {
            buffer.append(TOKENS[(number / 100) - 1]);
            number %= 100;
            tensFound = true;
        }

        if (number != 0) {
            if (tensFound) {
                buffer.append(SEPARATOR);
            }
            buffer.append(tensConverter.getName(number));
        }
        return buffer.toString();
    }
}
