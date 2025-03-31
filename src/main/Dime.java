import java.time.Year;

class Dime extends Coin {
    public Dime() {
        this(Year.now().getValue());
    }

    public Dime(int year) {
        super(0.10, year);
        commonName = "Dime";
        frontImage = "F_Roosevelt";
        backImage = "Torch_Branches";
        valueDescription = "ONE DIME";
        ridgedEdge = true;
        metallurgy = "Cupro-Nickel";
    }
}
