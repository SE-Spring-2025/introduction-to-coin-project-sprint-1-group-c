import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CopperTest {
    @Test
    public void testSmelt() {
        Metallurgy metal = new Copper();
        assertEquals("Copper", metal.smelt());
    }
}
