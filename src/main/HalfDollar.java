import java.time.Year;

class HalfDollar extends Coin {
    public HalfDollar() {
        this(Year.now().getValue());
    }

    public HalfDollar(int year) {
        super(0.50, year, "HalfDollar", new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = true;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "J_Kennedy";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Presidential_Seal";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "HALF DOLLAR";
    }
}
