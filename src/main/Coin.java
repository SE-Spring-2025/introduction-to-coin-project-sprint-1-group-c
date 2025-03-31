import java.text.DecimalFormat;
import java.time.Year;

public abstract class Coin {
    public String commonName;
    public double value;
    public String frontMotto = "IN GOD WE TRUST";
    public String backMotto = "E PLURIBUS UNUM";
    public String frontLabel = "LIBERTY";
    public String backLabel = "UNITED STATES OF AMERICA";
    public String frontImage;
    public String backImage;
    public String valueDescription;
    public boolean ridgedEdge;
    public String metallurgy;
    public int manufactureYear;

    public Coin(double value, int year) {
        this.value = value;
        this.manufactureYear = year;    
    }    

    public Coin(double value){
        this(value, Year.now().getValue());
    }

    public Coin(){
        this(0.0);
    }

    public double getValue() { return value; }
    public int getYear() { return manufactureYear; }
    public String getCommonName() { return commonName; }
    public String getFrontImage() { return frontImage; }
    public String getBackImage() { return backImage; }
    public String getValueDescription() { return valueDescription; }
    public boolean hasRidgedEdge() { return ridgedEdge; }
    public String getMetallurgy() { return metallurgy; }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "[" + commonName + "," + df.format(value) + "," + manufactureYear +
               ", '" + frontMotto + "', '" + backMotto + "', '" + frontImage + "', '" + backImage + "', '" +
               frontLabel + "', '" + backLabel + "', '" + valueDescription + "', " +
               (ridgedEdge ? "ridges" : "smooth") + ", '" + metallurgy + "']";
    }
}