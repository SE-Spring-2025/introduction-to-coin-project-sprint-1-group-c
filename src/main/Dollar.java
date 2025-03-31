import java.time.Year;

class Dollar extends Coin {
    public Dollar() {
        this(Year.now().getValue());
    }

    public Dollar(int year) {
        super(1.00, year);
        commonName = "Dollar";
        frontImage = "S_Anthony";
        backImage = "Moon_Eagle";
        valueDescription = "ONE DOLLAR";
        ridgedEdge = true;
        metallurgy = "Cupro-Nickel";
    }
}