import java.time.Year;

class Nickel extends Coin {
    public Nickel() {
        this(Year.now().getValue());
    }

    public Nickel(int year) {
        super(0.05, year);
        commonName = "Nickel";
        frontImage = "T_Jefferson";
        backImage = "Jefferson_Memorial";
        valueDescription = "FIVE CENTS";
        ridgedEdge = false;
        metallurgy = "Cupro-Nickel";
    }
}