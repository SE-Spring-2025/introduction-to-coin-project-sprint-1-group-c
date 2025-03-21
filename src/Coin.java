public class Coin {
    public double value; 
    public String commonName; 
    public String frontMotto;
    public int manufactureYear;
    public String frontImage;
    public String backImage;
    public String backMotto;
    public String frontLabel;
    public String backLabel;
    public String valueDescription;
    public boolean ridgedEdge;
    public String matallurgy;

    public Coin()
    {}    
    
    public Coin(double value)
    {
        this.value = value;
    }

    public Coin(double value, int year)
    {
        this.value = value;
        this.manufactureYear = year;
    }

    public String toString()
    {}
    
}