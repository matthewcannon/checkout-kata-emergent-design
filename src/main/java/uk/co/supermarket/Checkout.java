package uk.co.supermarket;

public class Checkout {

    private char itemCodeA;

    private int itemPriceA;

    private PricingCatalogue pricingCatalogue;

    public Checkout(char itemCodeA, int itemPriceA) {
        this(itemCodeA, itemPriceA, ' ', 0);
    }

    public Checkout(char itemCodeA, int itemPriceA, char itemCodeB, int itemPriceB) {
        this(new PricingCatalogue(itemCodeB, itemPriceB));
        this.itemCodeA = itemCodeA;
        this.itemPriceA = itemPriceA;
    }

    public Checkout(PricingCatalogue pricingCatalogue) {
        this.pricingCatalogue = pricingCatalogue;
    }

    public int scan(char itemCode) {
        if (itemCode == itemCodeA) {
            return itemPriceA;
        }

        return pricingCatalogue.priceOf(itemCode);
    }
}
