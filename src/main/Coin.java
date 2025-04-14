import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Coin {
    private double value;
    private int manufactureYear;
    private String commonName;
    private String frontMotto = "IN GOD WE TRUST";
    private String backMotto = "E PLURIBUS UNUM";
    private String frontLabel = "LIBERTY";
    private String backLabel = "UNITED STATES OF AMERICA";
    private String frontImage;
    private String backImage;
    private String valueDescription;
    private boolean ridgedEdge;
    private String metallurgy;
    private Metallurgy smelter;

    protected static CoinCounts coinCounts = new CoinCounts();

    public static CoinCounts getCoinCounts() {
        return coinCounts;
    }

    public Coin(double value, int manufactureYear, String commonName, String frontImage, String backImage, String valueDescription, boolean ridgedEdge, Metallurgy smelter) {
        this.value = value;
        this.manufactureYear = manufactureYear;
        this.commonName = commonName;
        this.frontImage = frontImage;
        this.backImage = backImage;
        this.valueDescription = valueDescription;
        this.ridgedEdge = ridgedEdge;
        this.smelter = smelter;
        this.metallurgy = this.smelt();
    }

    public double getValue() { return value; }
    public int getYear() { return manufactureYear; }
    public String getCommonName() { return commonName; }
    public String getFrontMotto() { return frontMotto; }
    public String getBackMotto() { return backMotto; }
    public String getFrontLabel() { return frontLabel; }
    public String getBackLabel() { return backLabel; }
    public String getFrontImage() { return frontImage; }
    public String getBackImage() { return backImage; }
    public String getValueDescription() { return valueDescription; }
    public boolean hasRidgedEdge() { return ridgedEdge; }
    public String getMetallurgy() { return metallurgy; }
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

    public static class CoinCounts {
        private int totalCoins = 0;
        private int quarterCount = 0;
        private List<CoinCountsObserver> observers = new ArrayList<>();

        public void registerObserver(CoinCountsObserver observer) {
            observers.add(observer);
        }

        private void notifyObservers() {
            for (CoinCountsObserver observer : observers) {
                observer.update(totalCoins, quarterCount);
            }
        }

        // Called when a non-quarter coin is created.
        public synchronized void incrementTotal() {
            totalCoins++;
            notifyObservers();
        }

        // Called when a quarter coin is created.
        // Note: A quarter is still a coin so we increment both counters.
        public synchronized void incrementQuarter() {
            quarterCount++;
            totalCoins++;
            notifyObservers();
        }
        
        public int getTotalCoins() { return totalCoins; }
        public int getQuarterCount() { return quarterCount; }
    }
  
}