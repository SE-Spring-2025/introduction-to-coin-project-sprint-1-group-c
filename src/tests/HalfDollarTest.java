import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class HalfDollarTest {
    @Test
    public void testHalfDollar() {
		HalfDollar c = new HalfDollar();
		int currYear = Year.now().getValue();
		
		assertEquals("HalfDollar", (c.getCommonName()));
		assertFalse(Double.compare(c.getValue(), 0.50) != 0);
		assertEquals("IN GOD WE TRUST", (c.getFrontMotto()));
		assertEquals("E PLURIBUS UNUM", (c.getBackMotto()));
		assertEquals("LIBERTY", (c.getFrontLabel()));
		assertEquals("UNITED STATES OF AMERICA", (c.getBackLabel()));
		assertEquals("J_Kennedy", (c.getFrontImage()));
		assertEquals("Presidential_Seal", (c.getBackImage()));
		assertEquals("HALF DOLLAR", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", c.smelt());
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}
