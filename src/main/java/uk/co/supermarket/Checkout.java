package uk.co.supermarket;

public final class Checkout {

    private PricingCatalogue pricingCatalogue;

    private int totalPrice = 0;

    public Checkout(char itemCodeA, int itemPriceA) {
        this(itemCodeA, itemPriceA, ' ', 0);
    }

    public Checkout(char itemCodeA, int itemPriceA, char itemCodeB, int itemPriceB) {
        this(new PricingCatalogue());

        pricingCatalogue.addItem(itemCodeA, itemPriceA);
        pricingCatalogue.addItem(itemCodeB, itemPriceB);
    }

    public Checkout(PricingCatalogue pricingCatalogue) {
        this.pricingCatalogue = pricingCatalogue;
    }

    public int scan(char itemCode) {
        totalPrice = pricingCatalogue.priceOf(itemCode);

        return getTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
