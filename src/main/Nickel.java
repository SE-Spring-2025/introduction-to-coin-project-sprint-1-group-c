import java.time.Year;

class Nickel extends Coin {
    public Nickel() {
        this(Year.now().getValue());
    }

    public Nickel(int year) {
        super(0.05, year, "Nickel", new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = false;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "T_Jefferson";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Jefferson_Memorial";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "FIVE CENTS";
    }
}