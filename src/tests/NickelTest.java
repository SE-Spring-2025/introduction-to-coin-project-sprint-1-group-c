import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Year;

import org.junit.Test;

public class NickelTest {
    @Test
    public void testNickel() {
        Nickel c = new Nickel();
        int currYear = Year.now().getValue();
        
        assertEquals("Nickel", (c.getCommonName()));
        assertEquals(Double.compare(c.getValue(), 0.05) != 0, false);
        assertEquals("IN GOD WE TRUST", (c.frontMotto));
        assertEquals("E PLURIBUS UNUM", (c.backMotto));
        assertEquals("LIBERTY", (c.frontLabel));
        assertEquals("UNITED STATES OF AMERICA", (c.backLabel));
        assertEquals("T_Jefferson", (c.getFrontImage()));
        assertEquals("Jefferson_Memorial", (c.getBackImage()));
        assertEquals("FIVE CENTS", (c.getValueDescription()));
        assertTrue(!c.hasRidgedEdge());
        assertEquals("Cupro-Nickel", c.smelt());
        assertEquals(currYear, c.getYear());
        
        // Test passes if it reaches here
        assertTrue(true);
    }
}
