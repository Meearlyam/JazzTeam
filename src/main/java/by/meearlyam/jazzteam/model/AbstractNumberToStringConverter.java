package by.meearlyam.jazzteam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class of number to string converter
 *
 * @author Vera Shavela
 * @version 1.0
 */
public abstract class AbstractNumberToStringConverter {
    static final String SEPARATOR = " ";
    static final int NO_VALUE = -1;

    static boolean flagSyntax = false;

    protected List<Integer> getDigits(long value) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        if (value == 0) {
            digits.add(0);
        } else {
            while (value > 0) {
                digits.add(0, (int) value % 10);
                value /= 10;
            }
        }
        return digits;
    }

    public String getName(long value) {
        return getName(Long.toString(value));
    }

    public String getName(double value) {
        return getName(Double.toString(value));
    }

    static void changeSyntax() {
        flagSyntax = !flagSyntax;
    }

    abstract String getName(String value);
}
