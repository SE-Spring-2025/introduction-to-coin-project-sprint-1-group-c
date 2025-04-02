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
		assertEquals("IN GOD WE TRUST", (c.frontMotto));
		assertEquals("E PLURIBUS UNUM", (c.backMotto));
		assertEquals("LIBERTY", (c.frontLabel));
		assertEquals("UNITED STATES OF AMERICA", (c.backLabel));
		assertEquals("G_Washington", (c.getFrontImage()));
		assertEquals("Eagle", (c.getBackImage()));
		assertEquals("QUARTER DOLLAR", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", (c.getMetallurgy()));
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}
