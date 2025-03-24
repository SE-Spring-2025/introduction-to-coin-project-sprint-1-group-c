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

    public Coin() {
    }

    public Coin(double value) {
        this.value = value;
    }

    public Coin(double value, int year) {
        this.value = value;
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
