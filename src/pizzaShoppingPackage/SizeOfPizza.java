package pizzaShoppingPackage;

public enum SizeOfPizza {

    BIG(10, 5000), SMALL(4, 1200), MEDIUM(6, 3000);
    private final int slices;
    private final int amount;

    SizeOfPizza(int slicesOfSize, int amount) {
        this.amount = amount;
        this.slices = slicesOfSize;
    }

    public int getNumberOfSlices(){
        return slices;
    }

    public  int getAmount(){
        return amount;
    }
}
