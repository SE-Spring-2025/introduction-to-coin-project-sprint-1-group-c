import java.time.Year;

public class Coin {
    private double value;
    private String commonName;
    private String frontMotto;
    private int manufactureYear;
    private String frontImage;
    private String backImage;
    private String backMotto;
    private String frontLabel;
    private String backLabel;
    private String valueDescription;
    private boolean ridgedEdge;
    private String matallurgy;

    public enum CoinType {
        PENNY,
        NICKEL,
        DIME,
        QUARTER,
        HALF_DOLLAR,
        DOLLAR,
        UNKNOWN_COIN;

        private static final CoinType[] COIN_TYPES = {
            PENNY,
            NICKEL,
            DIME,
            QUARTER,
            HALF_DOLLAR,
            DOLLAR
        };

        private static final double[] COIN_VALUES = {
            0.01,
            0.05,
            0.10,
            0.25,
            0.50,
            1.00
        };

        public static CoinType fromValue(double value) {
            for (int i = 0; i < COIN_TYPES.length; i++) {
                if (Math.abs(value - COIN_VALUES[i]) < 0.0001) {
                    return COIN_TYPES[i];
                }
            }
            return UNKNOWN_COIN;
        }

        public double getValue() {
            for (int i = 0; i < COIN_TYPES.length; i++) {
                if (this == COIN_TYPES[i]) {
                    return COIN_VALUES[i];
                }
            }
            return Double.NaN;
        }
    }

    public Coin() {
        this(0.0);
    }

    public Coin(double value) {
        this(value, Year.now().getValue());
    }

    public Coin(double value, int year) {
        CoinType coinType = CoinType.fromValue(value);

        switch (coinType) {
            case PENNY:
                // Penny
                this.commonName = "Penny";
                this.frontMotto = "IN GOD WE TRUST";
                this.frontImage = "Abraham Lincoln";
                this.frontLabel = "LIBERTY";
                this.backMotto = "E PLURIBUS UNUM";
                this.backImage = "Union Shield";
                this.backLabel = "UNITED STATES OF AMERICA";
                this.valueDescription = "ONE CENT";
                this.ridgedEdge = false;
                break;
            case NICKEL:
                // Nickel
                this.ridgedEdge = false;
                break;
            case DIME:
                // Dime
                this.ridgedEdge = true;
                break;
            case QUARTER:
                // Quarter
                this.ridgedEdge = true;
                break;
            case HALF_DOLLAR:
                // Half-dollar
                this.ridgedEdge = true;
                break;
            case DOLLAR:
                // Dollar
                this.ridgedEdge = true;
                break;
            case UNKNOWN_COIN:
                break;
        }

        this.value = coinType.getValue();
        this.manufactureYear = year;
    }

    public double getValue() {
        return value;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getFrontMotto() {
        return frontMotto;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public String getBackMotto() {
        return backMotto;
    }

    public String getFrontLabel() {
        return frontLabel;
    }

    public String getBackLabel() {
        return backLabel;
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public boolean isRidgedEdge() {
        return ridgedEdge;
    }

    public String getMatallurgy() {
        return matallurgy;
    }

    public String toString() {
        return null;
    }
}
