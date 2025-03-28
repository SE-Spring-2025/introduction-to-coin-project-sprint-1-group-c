class Dollar extends Coin {
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