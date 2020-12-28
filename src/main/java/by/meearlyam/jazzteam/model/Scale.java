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
        private int exponent;
        private String name;

        private ScaleUnit(int exponent, String name) {
            this.exponent = exponent;
            this.name = name;
        }

        public int getExponent() {
            return exponent;
        }

        public String getName() {
            return name;
        }
    }

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
            new ScaleUnit(3, "тысяч"),
            new ScaleUnit(-1, "десятых"),
            new ScaleUnit(-2, "сотых"),
            new ScaleUnit(-3, "тысячных"),
            new ScaleUnit(-4, "десятитытсячных"),
            new ScaleUnit(-5, "стотысячных"),
            new ScaleUnit(-6, "миллионных"),
    };

    public String getName(int exponent) {
        for (ScaleUnit unit : SCALE_UNITS) {
            if (unit.getExponent() == exponent) {
                return unit.getName();
            }
        }
        return "";
    }
}

