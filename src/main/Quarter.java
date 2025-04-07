import java.time.Year;

class Quarter extends Coin {
    public Quarter() {
        this(Year.now().getValue());
    }
    
    public Quarter(int year) {
        super(0.25, year, "Quarter", "G_Washington", "Eagle", "QUARTER DOLLAR", true, new CuproNickel());
    }
}