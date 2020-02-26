package uk.co.supermarket;

public class Checkout {

    private final char itemCodeA;

    private final int itemPriceA;

    public Checkout(char itemCodeA, int itemPriceA) {
        this.itemCodeA = itemCodeA;
        this.itemPriceA = itemPriceA;
    }

    public int scan(char itemCode) {
        if (itemCode == itemCodeA) {
            return itemPriceA;
        }

        return 0;
    }
}
