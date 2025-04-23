import java.time.Year;

class Dollar extends Coin {
    public Dollar() {
        this(Year.now().getValue());
    }

    public Dollar(int year) {
        super(1.00, year, "Dollar", new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = true;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "S_Anthony";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Moon_Eagle";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "ONE DOLLAR";
    }
}