import java.time.Year;

class Quarter extends Coin {
    public Quarter() {
        this(Year.now().getValue());
    }
    
    public Quarter(int year) {
        super(0.25, year, "Quarter", new CuproNickel());
        Coin.coinCounts.incrementQuarter();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = true;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "G_Washington";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Eagle";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "QUARTER DOLLAR";
    }
}