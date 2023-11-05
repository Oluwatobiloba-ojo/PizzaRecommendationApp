package pizzaShoppingPackage;

import java.util.Scanner;

public class PizzaClass {
    private int totalOfSlices;

    public int getValueOfSize(String size) {
        SizeOfPizza box = SizeOfPizza.valueOf(size.toUpperCase());
        return box.getNumberOfSlices();
    }

    public int getAmountOfSize(String size) {
        SizeOfPizza box = SizeOfPizza.valueOf(size.toUpperCase());
        return box.getAmount();
    }

    public void calculateHumanSlices(String people, int numberOfThem) {
        int result = 0;
        if (people.equalsIgnoreCase(String.valueOf(RangeOfSlicesForVariantPeople.SUPERHUNGRY))){
            result = RangeOfSlicesForVariantPeople.SUPERHUNGRY.getSlice() * numberOfThem;
        } else if (people.equalsIgnoreCase(String.valueOf(RangeOfSlicesForVariantPeople.HUNGRY))) {
            result = RangeOfSlicesForVariantPeople.HUNGRY.getSlice() * numberOfThem;
        }else if (people.equalsIgnoreCase(String.valueOf(RangeOfSlicesForVariantPeople.CLASSIC))){
            result = RangeOfSlicesForVariantPeople.CLASSIC.getSlice() * numberOfThem;
        }
        totalOfSlices += result;
    }

    public int getTheTotalOfSlices() {
        return totalOfSlices;
    }

    public int calculateNumberOfBoxesNeeded(String typeOfSize) {
        int numbOfBox = 0;
        int totalOfAll = getTheTotalOfSlices();
        int valueOfBox = SizeOfPizza.valueOf(typeOfSize.toUpperCase()).getNumberOfSlices();
        while (totalOfAll >= valueOfBox){
            totalOfAll -= valueOfBox;
            numbOfBox++;
        }
        if (totalOfAll != 0) numbOfBox++;
        return numbOfBox;
    }

    public int calculateRemnant(String typeOfSize) {
        return (calculateNumberOfBoxesNeeded(typeOfSize) *
                SizeOfPizza.valueOf(typeOfSize.toUpperCase()).getNumberOfSlices()) - getTheTotalOfSlices() ;
    }

    public int calculateTotalPrice(String typeOfSize) {
        return calculateNumberOfBoxesNeeded(typeOfSize) * SizeOfPizza.valueOf(typeOfSize.toUpperCase()).getAmount();
    }

    public static void display(String chars){
        for (int times = 0; times <= 25; times++){
            System.out.print(chars);
        }
        System.out.println();
    }
    public static void display(){
        PizzaClass myPizza = new PizzaClass();
        display("==");
        System.out.println("WELCOME TO SEMICOLON PIZZA APP OWNER MR CHIBUZOR");
        display("==");
        System.out.println("Enter the pizza box size you want for");
        String typeOfSize = collectInput();
        display(myPizza);
        displayResult(myPizza, typeOfSize);
    }

    private static void displayResult(PizzaClass myPizza, String typeOfSize) {
        display("==");
        System.out.println("Number of Slices is "+myPizza.getTheTotalOfSlices());
        System.out.println("Number of Boxes Needed " + myPizza.calculateNumberOfBoxesNeeded(typeOfSize));
        System.out.println("Number of slices left for "+myPizza.calculateRemnant(typeOfSize));
        System.out.println("Total Amount of Price is "+ myPizza.calculateTotalPrice(typeOfSize));
        display("==");
    }

    public static void display(PizzaClass myPizza){
        System.out.print(RangeOfSlicesForVariantPeople.SUPERHUNGRY+ "\t\t ");
        int number = Integer.parseInt(collectInput());
        myPizza.calculateHumanSlices(String.valueOf(RangeOfSlicesForVariantPeople.SUPERHUNGRY), number);
        System.out.print(RangeOfSlicesForVariantPeople.HUNGRY+ "\t\t ");
        number = Integer.parseInt(collectInput());
        myPizza.calculateHumanSlices(String.valueOf(RangeOfSlicesForVariantPeople.HUNGRY), number);
        System.out.print(RangeOfSlicesForVariantPeople.CLASSIC+ "\t\t ");
        number = Integer.parseInt(collectInput());
        myPizza.calculateHumanSlices(String.valueOf(RangeOfSlicesForVariantPeople.CLASSIC), number);
    }

    private static String collectInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
