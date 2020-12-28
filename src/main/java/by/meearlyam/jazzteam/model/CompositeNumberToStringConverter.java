package by.meearlyam.jazzteam.model;

/**
 * Composite number to string converter class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class CompositeNumberToStringConverter extends AbstractNumberToStringConverter {

    private static final Scale SCALE = new Scale();

    private ThousandsConverter thousandConverter = new ThousandsConverter();
    private AbstractNumberToStringConverter lowConverter;
    private int exponent;

    public CompositeNumberToStringConverter(int exponent) {
        if (exponent <= 6) {
            lowConverter = thousandConverter;
        } else {
            lowConverter = new CompositeNumberToStringConverter(exponent - 3);
        }
        this.exponent = exponent;
    }

    public String getToken() {
        return SCALE.getName(getPartDivider());
    }

    protected AbstractNumberToStringConverter getHighConverter() {
        return thousandConverter;
    }

    protected AbstractNumberToStringConverter getLowConverter() {
        return lowConverter;
    }

    public int getPartDivider() {
        return exponent;
    }

    @Override
    public String getName(String value) {

        StringBuilder buffer = new StringBuilder();

        int numberTemp = 0;
        int numberTemp2;

        String high;
        String low;

        if (value.length() < getPartDivider()) {
            high = "";
            low = value;
        } else {
            int index = value.length() - getPartDivider();
            high = value.substring(0, index);
            low = value.substring(index);
        }

        String highName = getHighConverter().getName(high);
        String lowName = getLowConverter().getName(low);

        if (!"".equals(highName)) {

            if (high.length() >= 2) {
                numberTemp = Integer.valueOf(high.substring(high.length() - 2).substring(0, 2), 10);
            }
            numberTemp2 = Integer.valueOf(high.substring(high.length() - 1).substring(0, 1), 10);

            buffer.append(highName);
            buffer.append(SEPARATOR);
            buffer.append(getToken());
            if (((numberTemp2 == 2) || numberTemp2 == 3 || numberTemp2 == 4) && (numberTemp != 12) && (numberTemp != 13) && (numberTemp != 14)) {
                buffer.append("а");
            } else {
                if (!(numberTemp2 == 1 && (numberTemp != 11))) {
                    buffer.append("ов");
                }
            }
            if (!"".equals(lowName)) {
                buffer.append(SEPARATOR);
            }
        }

        if (!"".equals(lowName)) {
            buffer.append(lowName);
        }

        return buffer.toString();
    }
}
