import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class QuarterCounter extends JFrame implements CoinCountsObserver, Runnable {
    private int quarters;
    private JLabel quarterCountLabel;
    private static final String LABEL_PREFIX = "Total Quarters: "; 

    public QuarterCounter(Coin.CoinCounts coinCounts) {
        coinCounts.registerObserver(this);
        this.quarters = coinCounts.getQuarterCount();
    }

    @Override
    public void update(int totalCoins, int quarterCount) {
        this.quarters = quarterCount;
        display();
    }

    public void display() {
        quarterCountLabel.setText(" " + LABEL_PREFIX + quarters + " ");
    }

    @Override
    public void run() {
        setTitle("Total Quaters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        quarterCountLabel = new JLabel(" " + LABEL_PREFIX + quarters + " ");
        add(quarterCountLabel);
        
        pack();
        setVisible(true);
    }
}