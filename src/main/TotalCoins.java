public class TotalCoins implements CoinCountsObserver {
    private int total;

    public TotalCoins(Coin.CoinCounts coinCounts) {
        coinCounts.registerObserver(this);
    }

    @Override
    public void update(int totalCoins, int quarterCount) {
        this.total = totalCoins;
        display();
    }

    public void display() {
        System.out.println("Total Coins: " + total);
    }
}