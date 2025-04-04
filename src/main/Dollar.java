import java.time.Year;

class Dollar extends Coin {
    public Dollar() {
        this(Year.now().getValue());
    }

    public Dollar(int year) {
        super(1.00, year, "Dollar", "S_Anthony", "Moon_Eagle", "ONE DOLLAR", true, new CuproNickel());
    }
}