import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ManufacturingTest {

    @Test
    void testDimeManufacturingPipeline() {
        Dime d = new Dime(2021);
        
        assertFalse(d.isFlipped());
        assertFalse(d.isBuffed());
        
        d.manufacture();

        assertTrue(d.isFlipped());
        assertTrue(d.isBuffed());
    }

    @Test
    void testPennyManufacturingPipeline() {
        Penny p = new Penny(2021);
        p.manufacture();
        
        assertTrue(p.isFlipped());
        assertTrue(p.isBuffed());
    }
}