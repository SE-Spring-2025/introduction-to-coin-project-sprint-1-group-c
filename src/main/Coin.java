import java.text.DecimalFormat;
import java.time.Year;

public abstract class Coin {
    public double value;
    public int manufactureYear;
    public String commonName;
    public String frontMotto = "IN GOD WE TRUST";
    public String backMotto = "E PLURIBUS UNUM";
    public String frontLabel = "LIBERTY";
    public String backLabel = "UNITED STATES OF AMERICA";
    public String frontImage;
    public String backImage;
    public String valueDescription;
    public boolean ridgedEdge;
    public Metallurgy smelter;

    public Coin(double value, int manufactureYear, String commonName, String frontImage, String backImage, String valueDescription, boolean ridgedEdge, Metallurgy smelter) {
        this.value = value;
        this.manufactureYear = manufactureYear;
        this.commonName = commonName;
        this.frontImage = frontImage;
        this.backImage = backImage;
        this.valueDescription = valueDescription;
        this.ridgedEdge = ridgedEdge;
        this.smelter = smelter;
    }

    public double getValue() { return value; }
    public int getYear() { return manufactureYear; }
    public String getCommonName() { return commonName; }
    public String getFrontImage() { return frontImage; }
    public String getBackImage() { return backImage; }
    public String getValueDescription() { return valueDescription; }
    public boolean hasRidgedEdge() { return ridgedEdge; }
    public Metallurgy getSmelter() { return smelter; }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "[" + commonName + "," + df.format(value) + "," + manufactureYear +
               ",'" + frontMotto + "','" + backMotto + "','" + frontImage + "','" + backImage + "','" +
               frontLabel + "','" + backLabel + "','" + valueDescription + "'," +
               (ridgedEdge ? "ridges" : "smooth") + ",'" + smelter.smelt() + "']";
    }

    public String smelt() {
        return this.smelter.smelt();
    }
}