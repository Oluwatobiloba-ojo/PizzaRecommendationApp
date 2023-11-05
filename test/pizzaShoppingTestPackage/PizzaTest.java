import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {

    @Test
    public void testForTheValueOfBigSizeToBeFour(){
        String size  = "Big";
        assertEquals(4, PizzaClass.getValueOfSize(size));
    }
}
