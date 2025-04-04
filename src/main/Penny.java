import java.time.Year;

class Penny extends Coin {
    public Penny() {
        this(Year.now().getValue());
    }

    public Penny(int year) {
        Metallurgy metal = new Copper();
        super(0.01, year, "Penny", "A_Lincoln", "Lincoln_Memorial", "ONE CENT", false, metal);
    }
}