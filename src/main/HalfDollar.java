import java.time.Year;

class HalfDollar extends Coin {
    public HalfDollar() {
        this(Year.now().getValue());
    }

    public HalfDollar(int year) {
        super(0.50, year, "HalfDollar", "J_Kennedy", "Presidential_Seal", "HALF DOLLAR", true, new CuproNickel());
    }
}
