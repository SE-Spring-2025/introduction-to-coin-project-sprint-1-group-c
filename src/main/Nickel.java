import java.time.Year;

class Nickel extends Coin {
    public Nickel() {
        this(Year.now().getValue());
    }

    public Nickel(int year) {
        super(0.05, year, "Nickel", "T_Jefferson", "Jefferson_Memorial", "FIVE CENTS", false, new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }
}