package pizzaShoppingPackage;

public enum RangeOfSlicesForVariantPeople {

    SUPERHUNGRY(4), HUNGRY(2), CLASSIC(1);

    private final int slice;
    RangeOfSlicesForVariantPeople(int slice){
        this.slice = slice;
    }

    public int getSlice(){
        return slice;
    }
}
