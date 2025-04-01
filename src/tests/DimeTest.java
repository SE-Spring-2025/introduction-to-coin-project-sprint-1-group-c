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
		assertEquals("IN GOD WE TRUST", (c.frontMotto));
		assertEquals("E PLURIBUS UNUM", (c.backMotto));
		assertEquals("LIBERTY", (c.frontLabel));
		assertEquals("UNITED STATES OF AMERICA", (c.backLabel));
		assertEquals("F_Roosevelt", (c.getFrontImage()));
		assertEquals("Torch_Branches", (c.getBackImage()));
		assertEquals("ONE DIME", (c.getValueDescription()));
		assertTrue(c.hasRidgedEdge());
		assertEquals("Cupro-Nickel", (c.getMetallurgy()));
		assertEquals(currYear, c.getYear());
		
		// Test passes if it reaches here
		assertTrue(true);
	}
}