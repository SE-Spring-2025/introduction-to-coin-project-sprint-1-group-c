class Penny extends Coin {
    public Penny(int year) {
        super(0.01, year);
        commonName = "Penny";
        frontImage = "A_Lincoln";
        backImage = "Lincoln_Memorial";
        valueDescription = "ONE CENT";
        ridgedEdge = false;
        metallurgy = "Copper";
    }
}