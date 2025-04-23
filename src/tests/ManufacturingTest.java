import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ManufacturingTest {

    @Test
    void testDimeManufacturingPipeline() {
        Dime d = new Dime(2021);
        
        assertFalse(d.isSmelted());
        assertFalse(d.isEdged());
        assertFalse(d.isFrontImageImprinted());
        assertFalse(d.isFrontDetailsImprinted());
        assertFalse(d.isFlipped());
        assertFalse(d.isBackImageImprinted());
        assertFalse(d.isBackDetailsImprinted());
        assertFalse(d.isBuffed());
        
        d.manufacture();

        assertTrue(d.isSmelted());
        assertTrue(d.isEdged());                 
        assertTrue(d.isFrontImageImprinted());
        assertTrue(d.isFrontDetailsImprinted());
        assertTrue(d.isFlipped());
        assertTrue(d.isBackImageImprinted());
        assertTrue(d.isBackDetailsImprinted());
        assertTrue(d.isBuffed());
    }

    @Test
    void testPennyManufacturingPipeline() {
        Penny p = new Penny(2021);
        p.manufacture();

        assertTrue(p.isSmelted());
        assertFalse(p.isEdged());
        assertTrue(p.isFrontImageImprinted());
        assertTrue(p.isFrontDetailsImprinted());
        assertTrue(p.isFlipped());
        assertTrue(p.isBackImageImprinted());
        assertTrue(p.isBackDetailsImprinted());
        assertTrue(p.isBuffed());
    }
}