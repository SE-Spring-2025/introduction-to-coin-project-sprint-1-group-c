import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CuproNickelTest {
    @Test
    public void testSmelt() {
        Metallurgy metal = new CuproNickel();
        assertEquals("Cupro-Nickel", metal.smelt());
    }
}