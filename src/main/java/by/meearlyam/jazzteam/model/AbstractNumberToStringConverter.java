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

    /**
     * converter separator for number string representation
     */
    static final String SEPARATOR = " ";

    /**
     * start value for offset
     */
    static final int NO_VALUE = -1;

    /**
     * flag that defines syntax type for words "один/одна" and "два/две"
     */
    static boolean flagSyntax = false;

    /**
     * get number digits
     *
     * @param value number value
     * @return list of number digits
     */
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

    /**
     * get string representation of long number
     *
     * @param value long number value
     * @return name string
     */
    public String getName(long value) {
        return getName(Long.toString(value));
    }

    /**
     * get string representation of double number
     *
     * @param value double number value
     * @return name string
     */
    public String getName(double value) {
        return getName(Double.toString(value));
    }

    /**
     * change syntax flag to opposite value
     *
     */
    static void changeSyntax() {
        flagSyntax = !flagSyntax;
    }

    /**
     * abstract method to get string representation of number string value
     *
     * @param value string value of number
     * @return string representation of number string value
     */
    abstract String getName(String value);
}
