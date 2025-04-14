public interface CoinCountsObserver {
    /**
     * Called when the coin counts are updated.
     *
     * @param totalCoins the current total number of coins
     * @param quarterCount the current total number of quarters
     */
    void update(int totalCoins, int quarterCount);
} 