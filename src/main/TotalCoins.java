import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class TotalCoins extends JFrame implements CoinCountsObserver, Runnable {
    private int total;
    private JLabel coinCountLabel;
    private static final String LABEL_PREFIX = "Total Coins: "; 

    public TotalCoins(Coin.CoinCounts coinCounts) {
        coinCounts.registerObserver(this);
        this.total = coinCounts.getTotalCoins();
    }

    @Override
    public void update(int totalCoins, int quarterCount) {
        this.total = totalCoins;
        display();
    }

    public void display() {
        if (coinCountLabel != null) {
            coinCountLabel.setText(" " + LABEL_PREFIX + total + " ");
        }
    }

    @Override
    public void run() {
        setTitle("Total Coins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        coinCountLabel = new JLabel(" " + LABEL_PREFIX + total + " ");
        add(coinCountLabel);
        
        pack();
        setVisible(true);
    }
}