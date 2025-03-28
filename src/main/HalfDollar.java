class HalfDollar extends Coin {
    public HalfDollar(int year) {
        super(0.50, year);
        commonName = "HalfDollar";
        frontImage = "J_Kennedy";
        backImage = "Presidential_Seal";
        valueDescription = "HALF DOLLAR";
        ridgedEdge = true;
        metallurgy = "Cupro-Nickel";
    }
}
