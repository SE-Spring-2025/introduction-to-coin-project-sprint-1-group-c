import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class DollarTest {
    @Test
    public void testDollar() {
		Coin c = new Dollar().manufacture();
		int currYear = Year.now().getValue();
		
		assertEquals("Dollar", (c.getCommonName()));
		assertFalse(Double.compare(c.getValue(), 1.00) != 0);
		assertEquals("IN GOD WE TRUST", (c.getFrontMotto()));
		assertEquals("E PLURIBUS UNUM", (c.getBackMotto()));
		assertEquals("LIBERTY", (c.getFrontLabel()));
		assertEquals("UNITED STATES OF AMERICA", (c.getBackLabel()));
		assertEquals("S_Anthony", (c.getFrontImage()));
		assertEquals("Moon_Eagle", (c.getBackImage()));
		assertEquals("ONE DOLLAR", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", c.smelt());
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}
