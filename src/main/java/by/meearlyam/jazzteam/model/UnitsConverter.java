package by.meearlyam.jazzteam.model;

/**
 * Units converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class UnitsConverter extends AbstractNumberToStringConverter {

    private static final String[] TOKENS = new String[]{"один", "два", "три", "четыре",
            "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
            "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static final String[] TOKENS_VARIABLE = new String[]{"одна", "две"};

    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();

        int offset = NO_VALUE;
        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }

        number %= 100;

        if (number < 10) {
            offset = (number % 10) - 1;
        } else if (number < 20) {
            offset = (number % 20) - 1;
        }

        if (offset != NO_VALUE && offset < TOKENS.length) {
            if (!flagSyntax) {
                buffer.append(TOKENS[offset]); //добавляем в конец строки
            } else {
                buffer.append(TOKENS_VARIABLE[offset]);
            }
        }
        return buffer.toString();
    }
}
