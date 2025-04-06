import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class PennyTest {
    @Test
    public void testPenny() {
        Penny c = new Penny();
        int currYear = Year.now().getValue();
        
        assertEquals("Penny", (c.getCommonName()));
        assertEquals(Double.compare(c.getValue(), 0.01) != 0, false);
        assertEquals("IN GOD WE TRUST", (c.frontMotto));
        assertEquals("E PLURIBUS UNUM", (c.backMotto));
        assertEquals("LIBERTY", (c.frontLabel));
        assertEquals("UNITED STATES OF AMERICA", (c.backLabel));
        assertEquals("A_Lincoln", (c.getFrontImage()));
        assertEquals("Lincoln_Memorial", (c.getBackImage()));
        assertEquals("ONE CENT", (c.getValueDescription()));
        assertFalse(c.hasRidgedEdge());
        assertEquals("Copper", c.smelt());
        assertEquals(currYear, c.getYear());
        
        // Test passes if it reaches here
        assertTrue(true);
    }
}
