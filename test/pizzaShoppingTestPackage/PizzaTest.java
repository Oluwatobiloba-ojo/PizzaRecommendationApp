package pizzaShoppingTestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzaShoppingPackage.PizzaClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {
    PizzaClass pizzaClass;
    @BeforeEach
    public void setPizzaClass(){
        pizzaClass = new PizzaClass();
    }

    @Test
    public void testForTheValueOfBigSizeToBeTen(){
        String size  = "Big";
        assertEquals(10, pizzaClass.getValueOfSize(size));
        assertEquals(5000, pizzaClass.getAmountOfSize(size));
    }

    @Test
    public void testForTheValueOfSmallSizeToBeFour(){
        String size = "Small";
        assertEquals(4, pizzaClass.getValueOfSize(size));
        assertEquals(1200, pizzaClass.getAmountOfSize(size));
    }

    @Test
    public void testForTheValueOfMediumSizeToBeSix(){
        String size = "Medium";
        assertEquals(6, pizzaClass.getValueOfSize(size));
        assertEquals(3000, pizzaClass.getAmountOfSize(size));
    }

    @Test
    public void testForTheNumberOfSlicesObtainFromARequest(){
        pizzaClass.calculateHumanSlices("SuperHungry", 10);
        pizzaClass.calculateHumanSlices("Hungry", 10);
        pizzaClass.calculateHumanSlices("Classic", 5);
        assertEquals(65, pizzaClass.getTheTotalOfSlices());
    }

    @Test
    public void testForTheNumberOfSlicesObtainFromARequestOfTwoCategory(){
        pizzaClass.calculateHumanSlices("Classic", 10);
        pizzaClass.calculateHumanSlices("SuperHungry", 20);
        assertEquals(90, pizzaClass.getTheTotalOfSlices());
    }

    @Test
    public void testForTheNumberOfBoxesAfterTheCalculationOfTheSlices(){
        pizzaClass.calculateHumanSlices("SuperHungry", 10);
        pizzaClass.calculateHumanSlices("Hungry", 10);
        pizzaClass.calculateHumanSlices("Classic", 5);
        int numberOfBox = pizzaClass.calculateNumberOfBoxesNeeded("Big");
        assertEquals(7, numberOfBox);
    }

    @Test
    public void testForTheNumberOfBoxesAfterCalculationForTwoCategory(){
        pizzaClass.calculateHumanSlices("Classic", 10);
        pizzaClass.calculateHumanSlices("SuperHungry", 20);
        int numberOfBox = pizzaClass.calculateNumberOfBoxesNeeded("Medium");
        assertEquals(15, numberOfBox);
    }

    @Test
    public void testForTheNumberOfSlicesLeftAfterSummingCategory(){
        pizzaClass.calculateHumanSlices("SuperHungry", 10);
        pizzaClass.calculateHumanSlices("Hungry", 10);
        pizzaClass.calculateHumanSlices("Classic", 5);
        int leftOver = pizzaClass.calculateRemnant("Big");
        assertEquals(5, leftOver);
    }

    @Test
    public void testForTheNumberOfSlicesForTwoCategoryOfPeople(){
        pizzaClass.calculateHumanSlices("Classic", 10);
        pizzaClass.calculateHumanSlices("SuperHungry", 20);
        int left = pizzaClass.calculateRemnant("Medium");
        assertEquals(0, left);
    }

    @Test
    public void testForTheTotalCostOfTheBoxOfPizza(){
        pizzaClass.calculateHumanSlices("SuperHungry", 10);
        pizzaClass.calculateHumanSlices("Hungry", 10);
        pizzaClass.calculateHumanSlices("Classic", 5);
        int totalCost = pizzaClass.calculateTotalPrice("Big");
        assertEquals(35000, totalCost);
    }
    @Test
    public void testForTheTotalPriceOfTheBoxOfPizza(){
        pizzaClass.calculateHumanSlices("Classic", 10);
        pizzaClass.calculateHumanSlices("SuperHungry", 20);
        int totalPrice = pizzaClass.calculateTotalPrice("Medium");
        assertEquals(45000, totalPrice);
    }

}
