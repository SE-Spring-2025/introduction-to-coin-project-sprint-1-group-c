import java.time.Year;

class HalfDollar extends Coin {
    public HalfDollar() {
        this(Year.now().getValue());
    }

    public HalfDollar(int year) {
        super(0.50, year);
        commonName = "HalfDollar";
        frontImage = "J_Kennedy";
        backImage = "Presidential_Seal";
        valueDescription = "HALF DOLLAR";
        ridgedEdge = true;
        metallurgy = "Cupro-Nickel";
    }
}
