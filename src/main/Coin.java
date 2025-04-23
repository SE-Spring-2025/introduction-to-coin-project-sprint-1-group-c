import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Coin {
    protected static final String DEFAULT_FRONT_MOTTO = "IN GOD WE TRUST";
    protected static final String DEFAULT_BACK_MOTTO = "E PLURIBUS UNUM";
    protected static final String DEFAULT_FRONT_LABEL = "LIBERTY";
    protected static final String DEFAULT_BACK_LABEL = "UNITED STATES OF AMERICA";
    
    private double value;
    private int manufactureYear;
    private String commonName;
    protected String frontMotto;
    protected String backMotto;
    protected String frontLabel;
    protected String backLabel;
    protected String frontImage;
    protected String backImage;
    protected String valueDescription;
    protected boolean ridgedEdge;
    private Metallurgy smelter;

    protected static CoinCounts coinCounts = new CoinCounts();

    public static CoinCounts getCoinCounts() {
        return coinCounts;
    }

    // Flags for manufacturing method
    private boolean flipped                = false;
    private boolean buffed                 = false;

    // Blob only constructor 
    protected Coin(double value, int manufactureYear, String commonName, Metallurgy smelter) {
        this.value            = value;
        this.manufactureYear  = manufactureYear;
        this.commonName       = commonName;
        this.smelter          = smelter;
    }
    
    
    public final Coin manufacture() {
        smeltStep();
        edgeStep();
        imprintFrontImage();
        imprintFrontDetails();
        flip();
        imprintBackImage();
        imprintBackDetails();
        buff();
        return this;
    }

   
    // 1. cure the metal alloy via our strategy 
    protected void smeltStep() {
        smelter.smelt();
    }

    // 2. apply ridges if called for 
    protected abstract void edgeStep();

    // 3. press the front image 
    protected abstract void imprintFrontImage();

    // 4. press the front motto, year, and label 
    protected void imprintFrontDetails() {
        this.frontMotto = Coin.DEFAULT_FRONT_MOTTO;
        this.frontLabel = Coin.DEFAULT_FRONT_LABEL;
    }

    // 5. flip it over 
    protected final void flip() {
        flipped = true;
    }

    // 6. press the back image 
    protected abstract void imprintBackImage();

    // 7. press the back motto, value, and label 
    protected abstract void imprintBackDetails();

    // 8. final polishing 
    protected final void buff() {
        buffed = true;
    }

    // testing getters
    public boolean isFlipped()               { return flipped; }
    public boolean isBuffed()                { return buffed; }

    
    public double getValue()                  { return value; }
    public int    getYear()                   { return manufactureYear; }
    public String getCommonName()             { return commonName; }
    public String getFrontMotto()             { return frontMotto; }
    public String getBackMotto()              { return backMotto; }
    public String getFrontLabel()             { return frontLabel; }
    public String getBackLabel()              { return backLabel; }
    public String getFrontImage()             { return frontImage; }
    public String getBackImage()              { return backImage; }
    public String getValueDescription()       { return valueDescription; }
    public boolean hasRidgedEdge()            { return ridgedEdge; }
    public Metallurgy getSmelter()            { return smelter; }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "[" + commonName + "," + df.format(value) + "," + manufactureYear +
               ",'" + frontMotto + "','" + backMotto + "','" +
               frontImage + "','" + backImage + "','" +
               frontLabel + "','" + backLabel + "','" +
               valueDescription + "'," +
               (ridgedEdge ? "ridges" : "smooth") +
               ",'" + smelter.smelt() + "']";
    }

    public String smelt() {
        return smelter.smelt();
    }
    
    public static class CoinCounts {
        private int totalCoins    = 0;
        private int quarterCount  = 0;
        private List<CoinCountsObserver> observers = new ArrayList<>();

        public void registerObserver(CoinCountsObserver observer) {
            observers.add(observer);
        }

        private void notifyObservers() {
            for (CoinCountsObserver obs : observers) {
                obs.update(totalCoins, quarterCount);
            }
        }

        public synchronized void incrementTotal() {
            totalCoins++;
            notifyObservers();
        }

        public synchronized void incrementQuarter() {
            quarterCount++;
            totalCoins++;
            notifyObservers();
        }

        public int getTotalCoins()   { return totalCoins; }
        public int getQuarterCount() { return quarterCount; }
    }
}