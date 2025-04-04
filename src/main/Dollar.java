import java.time.Year;

class Dollar extends Coin {
    public Dollar() {
        this(Year.now().getValue());
    }

    public Dollar(int year) {
        Metallurgy metal = new CuproNickel();
        super(1.00, year, "Dollar", "S_Anthony", "Moon_Eagle", "ONE DOLLAR", true, metal);
    }
}