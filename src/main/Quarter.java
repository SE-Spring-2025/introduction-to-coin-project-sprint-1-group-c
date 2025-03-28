class Quarter extends Coin {
    public Quarter(int year) {
        super(0.25, year);
        commonName = "Quarter";
        frontImage = "G_Washington";
        backImage = "Eagle";
        valueDescription = "QUARTER DOLLAR";
        ridgedEdge = true;
        metallurgy = "Cupro-Nickel";
    }
}