package by.meearlyam.jazzteam.model;

/**
 * Thousands converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class ThousandsConverter extends AbstractNumberToStringConverter {

    private static final int EXPONENT = 3;
    private static final Scale SCALE = new Scale();

    private HundredsConverter hundredsConverter = new HundredsConverter();

    @Override
    public String getName(String value) {

        StringBuilder buffer = new StringBuilder();

        int number;
        int numberTemp = 0;
        int numberTemp2;

        if ("".equals(value)) {
            number = 0;
        } else {
            if (value.length() > 6) {
                number = Integer.valueOf(value.substring(value.length() - 6), 10); //оставляем 6 знаков для тысяч/тысячи
                numberTemp = Integer.valueOf(value.substring(value.length() - 5).substring(0, 2), 10);
            } else {
                number = Integer.valueOf(value, 10);
            }
        }

        if (number >= 1000) {
            if (value.length() > 5) {
                //определяем последние 2 знакa для нахождения окночания слова тысячи
                numberTemp = Integer.valueOf(value.substring(value.length() - 5).substring(0, 2), 10);
                numberTemp2 = Integer.valueOf(value.substring(value.length() - 4).substring(0, 1), 10);
            } else {
                if (value.length() > 4) {
                    numberTemp = Integer.valueOf(value.substring(value.length() - 5).substring(0, 2), 10);
                }
                numberTemp2 = Integer.valueOf(value.substring(value.length() - 4).substring(0, 1), 10);
            }

            //замена один/одна и два/две
            if ((numberTemp2 == 1 || numberTemp2 == 2) && (numberTemp != 11) && (numberTemp != 12)) {
                changeSyntax();
                buffer.append(hundredsConverter.getName(number / 1000));
                //возвращаем флаг замены
                changeSyntax();
            } else {
                buffer.append(hundredsConverter.getName(number / 1000));
            }

            buffer.append(SEPARATOR);
            buffer.append(SCALE.getName(EXPONENT));
            if (((numberTemp2 == 2) || numberTemp2 == 3 || numberTemp2 == 4) && (numberTemp != 12) && (numberTemp != 13) && (numberTemp != 14)) {
                buffer.append("и");
            }
            if ((numberTemp2 == 1) && (numberTemp != 11)) {
                buffer.append("а");
            }
        }

        String hundredsName = hundredsConverter.getName(number);

        if (!"".equals(hundredsName) && (number >= 1000)) {
            buffer.append(SEPARATOR);
        }
        buffer.append(hundredsName);

        return buffer.toString();
    }
}
