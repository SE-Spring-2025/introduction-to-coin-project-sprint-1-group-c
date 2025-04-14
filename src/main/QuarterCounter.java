public class QuarterCounter implements CoinCountsObserver {
    private int quarters;

    public QuarterCounter(Coin.CoinCounts coinCounts) {
        coinCounts.registerObserver(this);
    }

    @Override
    public void update(int totalCoins, int quarterCount) {
        this.quarters = quarterCount;
        display();
    }

    public void display() {
        System.out.println("Total Quarters: " + quarters);
    }
}