import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Coin {
    private double value;
    private int manufactureYear;
    private String commonName;
    private String frontMotto        = "IN GOD WE TRUST";
    private String backMotto         = "E PLURIBUS UNUM";
    private String frontLabel        = "LIBERTY";
    private String backLabel         = "UNITED STATES OF AMERICA";
    private String frontImage;
    private String backImage;
    private String valueDescription;
    private boolean ridgedEdge;
    private Metallurgy smelter;

    protected static CoinCounts coinCounts = new CoinCounts();

    public static CoinCounts getCoinCounts() {
        return coinCounts;
    }

    // Flags for manufactiing method 
    private boolean smelted                = false;
    private boolean edged                  = false;
    private boolean frontImageImprinted    = false;
    private boolean frontDetailsImprinted  = false;
    private boolean flipped                = false;
    private boolean backImageImprinted     = false;
    private boolean backDetailsImprinted   = false;
    private boolean buffed                 = false;

    // Blob only constructor 
    protected Coin(double value, int manufactureYear, String commonName, String frontImage, String backImage, String valueDescription, boolean ridgedEdge, Metallurgy smelter) {
        this.value            = value;
        this.manufactureYear  = manufactureYear;
        this.commonName       = commonName;
        this.frontImage       = frontImage;
        this.backImage        = backImage;
        this.valueDescription = valueDescription;
        this.ridgedEdge       = ridgedEdge;
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
        smelted = true;
    }

    // 2. apply ridges if called for 
    protected void edgeStep() {
        if (ridgedEdge) edged = true;
    }

    // 3. press the front image 
    protected void imprintFrontImage() {
        frontImageImprinted = true;
    }

    // 4. press the front motto, year, and label 
    protected void imprintFrontDetails() {
        frontDetailsImprinted = true;
    }

    // 5. flip it over 
    protected final void flip() {
        flipped = true;
    }

    // 6. press the back image 
    protected void imprintBackImage() {
        backImageImprinted = true;
    }

    // 7. press the back motto, value, and label 
    protected void imprintBackDetails() {
        backDetailsImprinted = true;
    }

    // 8. final polishing 
    protected final void buff() {
        buffed = true;
    }

    // testing getters
    public boolean isSmelted()               { return smelted; }
    public boolean isEdged()                 { return edged; }
    public boolean isFrontImageImprinted()   { return frontImageImprinted; }
    public boolean isFrontDetailsImprinted() { return frontDetailsImprinted; }
    public boolean isFlipped()               { return flipped; }
    public boolean isBackImageImprinted()    { return backImageImprinted; }
    public boolean isBackDetailsImprinted()  { return backDetailsImprinted; }
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