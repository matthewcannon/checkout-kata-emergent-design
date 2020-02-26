package uk.co.supermarket;

public class Checkout {

    private final char itemCodeA;

    private final int itemPriceA;

    private final char itemCodeB;

    private final int itemPriceB;

    public Checkout(char itemCodeA, int itemPriceA) {
        this(itemCodeA, itemPriceA, ' ', 0);
    }

    public Checkout(char itemCodeA, int itemPriceA, char itemCodeB, int itemPriceB) {
        this.itemCodeA = itemCodeA;
        this.itemPriceA = itemPriceA;
        this.itemCodeB = itemCodeB;
        this.itemPriceB = itemPriceB;
    }

    public int scan(char itemCode) {
        if (itemCode == itemCodeA) {
            return itemPriceA;
        }

        if (itemCode == itemCodeB) {
            return itemPriceB;
        }

        return 0;
    }
}
