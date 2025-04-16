public interface CoinCountsObserver {
    /**
     * Called when the coin counts are updated.
     *
     * @param totalCoins
     * @param quarterCount
     */
    void update(int totalCoins, int quarterCount);
} 