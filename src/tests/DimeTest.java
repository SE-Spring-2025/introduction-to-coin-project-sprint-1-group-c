import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class DimeTest {
    @Test
    public void testDime() {
		Dime c = new Dime();
		int currYear = Year.now().getValue();
		
		assertEquals("Dime", (c.getCommonName()));
		assertFalse(Double.compare(c.getValue(), 0.10) != 0);
		assertEquals("IN GOD WE TRUST", (c.getFrontMotto()));
		assertEquals("E PLURIBUS UNUM", (c.getBackMotto()));
		assertEquals("LIBERTY", (c.getFrontLabel()));
		assertEquals("UNITED STATES OF AMERICA", (c.getBackLabel()));
		assertEquals("F_Roosevelt", (c.getFrontImage()));
		assertEquals("Torch_Branches", (c.getBackImage()));
		assertEquals("ONE DIME", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", c.smelt());
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}