import java.time.Year;

class Dime extends Coin {
    public Dime() {
        this(Year.now().getValue());
    }

    public Dime(int year) {
        super(0.10, year, "Dime", new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }

    @Override
    protected void edgeStep() {
        this.ridgedEdge = true;
    }

    @Override
    protected void imprintFrontImage() {
        this.frontImage = "F_Roosevelt";
    }

    @Override
    protected void imprintBackImage() {
        this.backImage = "Torch_Branches";
    }

    @Override
    protected void imprintBackDetails() {
        this.backMotto = Coin.DEFAULT_BACK_MOTTO;
        this.backLabel = Coin.DEFAULT_BACK_LABEL;
        this.valueDescription = "ONE DIME";
    }
}
