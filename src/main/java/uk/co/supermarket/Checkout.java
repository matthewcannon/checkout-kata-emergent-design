package uk.co.supermarket;

public class Checkout {

    private final char itemCodeA;

    private final int itemPriceA;

    private final PricingCatalogue pricingCatalogue;

    private char itemCodeB;

    private int itemPriceB;

    public Checkout(char itemCodeA, int itemPriceA) {
        this(itemCodeA, itemPriceA, ' ', 0);
    }

    public Checkout(char itemCodeA, int itemPriceA, char itemCodeB, int itemPriceB) {
        this(itemCodeA, itemPriceA, new PricingCatalogue());
        this.itemCodeB = itemCodeB;
        this.itemPriceB = itemPriceB;
    }

    public Checkout(char itemCodeA, int itemPriceA, PricingCatalogue pricingCatalogue) {
        this.itemCodeA = itemCodeA;
        this.itemPriceA = itemPriceA;
        this.pricingCatalogue = pricingCatalogue;
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
