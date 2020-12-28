package by.meearlyam.jazzteam.model;

/**
 * Number scale enum
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class Scale {

    /**
     * Inner number scale unit class
     *
     * @author Vera Shavela
     * @version 1.0
     */
    private static class ScaleUnit {

        /**
         * exponent number value
         */
        private int exponent;

        /**
         * exponent string value
         */
        private String name;

        /**
         * scale unit constructor
         *
         * @param exponent exponent number value
         * @param name exponent string value
         */
        private ScaleUnit(int exponent, String name) {
            this.exponent = exponent;
            this.name = name;
        }

        /**
         * get exponent number value
         *
         * @return exponent number value
         */
        public int getExponent() {
            return exponent;
        }

        /**
         * get exponent string value
         *
         * @return exponent string value
         */
        public String getName() {
            return name;
        }
    }

    /**
     * scale units array
     */
    private static final ScaleUnit[] SCALE_UNITS = new ScaleUnit[]{
            new ScaleUnit(63, "вигинтиллион"),
            new ScaleUnit(60, "новемдециллион"),
            new ScaleUnit(57, "октодециллион"),
            new ScaleUnit(54, "септемдециллион"),
            new ScaleUnit(51, "сексдециллион"),
            new ScaleUnit(48, "квиндециллион"),
            new ScaleUnit(45, "кваттордециллион"),
            new ScaleUnit(42, "тредециллион"),
            new ScaleUnit(39, "дуодециллион"),
            new ScaleUnit(36, "андециллион"),
            new ScaleUnit(33, "дециллион"),
            new ScaleUnit(30, "нониллион"),
            new ScaleUnit(27, "октиллион"),
            new ScaleUnit(24, "септиллион"),
            new ScaleUnit(21, "секстиллион"),
            new ScaleUnit(18, "квинтиллион"),
            new ScaleUnit(15, "квадриллион"),
            new ScaleUnit(12, "триллион"),
            new ScaleUnit(9, "миллиард"),
            new ScaleUnit(6, "миллион"),
            new ScaleUnit(3, "тысяч")
    };

    /**
     * get exponent string representation
     *
     * @param exponent number exponent value
     * @return string exponent representation
     */
    public String getName(int exponent) {
        for (ScaleUnit unit : SCALE_UNITS) {
            if (unit.getExponent() == exponent) {
                return unit.getName();
            }
        }
        return "";
    }
}

