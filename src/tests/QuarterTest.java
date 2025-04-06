import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class QuarterTest {
    @Test
    public void testQuarter() {
		Quarter c = new Quarter();
		int currYear = Year.now().getValue();
		
		assertEquals("Quarter", (c.getCommonName()));
		assertFalse(Double.compare(c.getValue(), 0.25) != 0);
		assertEquals("IN GOD WE TRUST", (c.getFrontMotto()));
		assertEquals("E PLURIBUS UNUM", (c.getBackMotto()));
		assertEquals("LIBERTY", (c.getFrontLabel()));
		assertEquals("UNITED STATES OF AMERICA", (c.getBackLabel()));
		assertEquals("G_Washington", (c.getFrontImage()));
		assertEquals("Eagle", (c.getBackImage()));
		assertEquals("QUARTER DOLLAR", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", c.smelt());
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}
