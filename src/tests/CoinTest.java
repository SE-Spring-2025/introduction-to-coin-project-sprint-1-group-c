import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Calendar;

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
	    Coin c = new MockCoin();
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
		Coin c = new MockCoin();

		assertEquals("Mock", (c.getCommonName()));
		assertFalse(Double.compare(c.getValue(), 0.24) != 0);
		assertEquals("IN GOD WE TRUST", (c.getFrontMotto()));
		assertEquals("E PLURIBUS UNUM", (c.getBackMotto()));
		assertEquals("LIBERTY", (c.getFrontLabel()));
		assertEquals("UNITED STATES OF AMERICA", (c.getBackLabel()));
		assertEquals("frontImage", (c.getFrontImage()));
		assertEquals("backImage", (c.getBackImage()));
		assertEquals("twenty-four cents", (c.getValueDescription()));
		assertFalse(c.hasRidgedEdge());
		assertEquals("metallurgy", c.smelt());
		assertEquals(currYear, c.getYear());
		
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


	@Test
public void testSmelt() {
    Coin dime = new Dime(2021);
    assertEquals("Cupro-Nickel", dime.smelt());

    Coin mock = new MockCoin();

    assertEquals("metallurgy", mock.smelt());
}
}



class MockCoin extends Coin {
    public MockCoin() {
        this(Year.now().getValue());
    }

    public MockCoin(int year) {
        super(0.24, year, "Mock", "frontImage", "backImage", "twenty-four cents", false,
              new Metallurgy() {
                  @Override
                  public String smelt() { return "metallurgy"; }
              });
    }
}