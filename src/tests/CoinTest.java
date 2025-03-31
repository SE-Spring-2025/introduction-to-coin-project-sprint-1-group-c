import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CoinTest{
    private static int currYear;
    
    @BeforeAll
    public static void getCurrYear() {
	currYear = (Calendar.getInstance()).get(Calendar.YEAR);
    }

    @Test
    public void testConstructors() {
	// Basically just make sure they don't blow up
	// parameterless constructor
	try {
	    MockCoin c = new Coin();
	}
	catch (Exception e) {
	    fail("Coin() constructor caused exception: "+e.getMessage());
	}

	// value arg constructor
	try {
	    Coin c = new Nickel();
	}
	catch (Exception e) {
	    fail("Coin() constructor caused exception: "+e.getMessage());
	}

	// value and year args constructor
	try {
	    Coin c = new Dime(2020);
	}
	catch (Exception e) {
	    fail("Coin() constructor caused exception: "+e.getMessage());
	}

	// make it here then didn't fail!
	assertTrue(true);
    }

    @Test
    public void testGetters() {
	if (! testPenny()) fail("penny getters failed");
	if (! testNickel()) fail("nickel getters failed");
	if (! testDime()) fail("dime getters failed");
	if (! testQuarter()) fail("quarter getters failed");
	if (! testHalfDollar()) fail("half dollar getters failed");
	if (! testDollar()) fail("dollar getters failed");
	
	// make it here then didn't fail!
	assertTrue(true);
    }

    @Test
    public void testToString() {
	Coin c = new HalfDollar(1999);
	String expectedOutput =
	    "[HalfDollar,0.50,1999,'IN GOD WE TRUST','E PLURIBUS UNUM'"
	    + ",'J_Kennedy','Presidential_Seal','LIBERTY'"
	    + ",'UNITED STATES OF AMERICA','HALF DOLLAR',ridges"
	    + ",'Cupro-Nickel']";
	assertEquals(expectedOutput, c.toString());
    }

    //---------------------------------------------------------
    // private helper methods
    //---------------------------------------------------------
    
    private boolean cmpDoubles(double a, double b) {
	return Math.abs(a-b) < 0.00001;
    }
    
private boolean testPenny() {
    Penny c = new Penny();
    int currYear = Year.now().getValue();
    
    if (!"Penny".equals(c.getCommonName())) return false;
    if (Double.compare(c.getValue(), 0.01) != 0) return false;
    if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
    if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
    if (!"LIBERTY".equals(c.frontLabel)) return false;
    if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
    if (!"A_Lincoln".equals(c.getFrontImage())) return false;
    if (!"Lincoln_Memorial".equals(c.getBackImage())) return false;
    if (!"ONE CENT".equals(c.getValueDescription())) return false;
    if (c.hasRidgedEdge()) return false;
    if (!"Copper".equals(c.getMetallurgy())) return false;
    if (currYear != c.getYear()) return false;
    
    // Test passes if it reaches here
    return true;
}

	
private boolean testNickel() {
    Nickel c = new Nickel();
    int currYear = Year.now().getValue();
    
    if (!"Nickel".equals(c.getCommonName())) return false;
    if (Double.compare(c.getValue(), 0.05) != 0) return false;
    if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
    if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
    if (!"LIBERTY".equals(c.frontLabel)) return false;
    if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
    if (!"T_Jefferson".equals(c.getFrontImage())) return false;
    if (!"Jefferson_Memorial".equals(c.getBackImage())) return false;
    if (!"FIVE CENTS".equals(c.getValueDescription())) return false;
    if (c.hasRidgedEdge()) return false;
    if (!"Cupro-Nickel".equals(c.getMetallurgy())) return false;
    if (currYear != c.getYear()) return false;
    
    // Test passes if it reaches here
    return true;
    }
	
	private boolean testDime() {
		Dime c = new Dime();
		int currYear = Year.now().getValue();
		
		if (!"Dime".equals(c.getCommonName())) return false;
		if (Double.compare(c.getValue(), 0.10) != 0) return false;
		if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
		if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
		if (!"LIBERTY".equals(c.frontLabel)) return false;
		if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
		if (!"F_Roosevelt".equals(c.getFrontImage())) return false;
		if (!"Torch_Branches".equals(c.getBackImage())) return false;
		if (!"ONE DIME".equals(c.getValueDescription())) return false;
		if (!c.hasRidgedEdge()) return false;
		if (!"Cupro-Nickel".equals(c.getMetallurgy())) return false;
		if (currYear != c.getYear()) return false;
		
		// Test passes if it reaches here
		return true;
	}
	

    private boolean testQuarter() {
		Quarter c = new Quarter();
		int currYear = Year.now().getValue();
		
		if (!"Quarter".equals(c.getCommonName())) return false;
		if (Double.compare(c.getValue(), 0.25) != 0) return false;
		if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
		if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
		if (!"LIBERTY".equals(c.frontLabel)) return false;
		if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
		if (!"G_Washington".equals(c.getFrontImage())) return false;
		if (!"Eagle".equals(c.getBackImage())) return false;
		if (!"QUARTER DOLLAR".equals(c.getValueDescription())) return false;
		if (!c.hasRidgedEdge()) return false;
		if (!"Cupro-Nickel".equals(c.getMetallurgy())) return false;
		if (currYear != c.getYear()) return false;
		
		// Test passes if it reaches here
		return true;
	}


    private boolean testHalfDollar() {
		HalfDollar c = new HalfDollar();
		int currYear = Year.now().getValue();
		
		if (!"HalfDollar".equals(c.getCommonName())) return false;
		if (Double.compare(c.getValue(), 0.50) != 0) return false;
		if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
		if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
		if (!"LIBERTY".equals(c.frontLabel)) return false;
		if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
		if (!"J_Kennedy".equals(c.getFrontImage())) return false;
		if (!"Presidential_Seal".equals(c.getBackImage())) return false;
		if (!"HALF DOLLAR".equals(c.getValueDescription())) return false;
		if (!c.hasRidgedEdge()) return false;
		if (!"Cupro-Nickel".equals(c.getMetallurgy())) return false;
		if (currYear != c.getYear()) return false;
		
		// Test passes if it reaches here
		return true;
	}
    
	private boolean testDollar() {
		Dollar c = new Dollar();
		int currYear = Year.now().getValue();
		
		if (!"Dollar".equals(c.getCommonName())) return false;
		if (Double.compare(c.getValue(), 1.00) != 0) return false;
		if (!"IN GOD WE TRUST".equals(c.frontMotto)) return false;
		if (!"E PLURIBUS UNUM".equals(c.backMotto)) return false;
		if (!"LIBERTY".equals(c.frontLabel)) return false;
		if (!"UNITED STATES OF AMERICA".equals(c.backLabel)) return false;
		if (!"S_Anthony".equals(c.getFrontImage())) return false;
		if (!"Moon_Eagle".equals(c.getBackImage())) return false;
		if (!"ONE DOLLAR".equals(c.getValueDescription())) return false;
		if (!c.hasRidgedEdge()) return false;
		if (!"Cupro-Nickel".equals(c.getMetallurgy())) return false;
		if (currYear != c.getYear()) return false;
		
		// Test passes if it reaches here
		return true;
	}
}