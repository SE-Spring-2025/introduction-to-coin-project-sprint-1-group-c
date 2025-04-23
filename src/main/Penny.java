import java.time.Year;

class Penny extends Coin {
    public Penny() {
        this(Year.now().getValue());
    }

    public Penny(int year) {
        super(0.01, year, "Penny", new Copper());
        Coin.coinCounts.incrementTotal();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = false;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "A_Lincoln";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Lincoln_Memorial";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "ONE CENT";
    }
}