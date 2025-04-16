import java.time.Year;

class Dime extends Coin {
    public Dime() {
        this(Year.now().getValue());
    }

    public Dime(int year) {
        super(0.10, year, "Dime", "F_Roosevelt", "Torch_Branches", "ONE DIME", true, new CuproNickel());
        Coin.coinCounts.incrementTotal();
    }
}
