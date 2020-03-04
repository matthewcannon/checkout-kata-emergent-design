package uk.co.supermarket;

public final class Checkout {

    private PricingCatalogue pricingCatalogue;

    private int totalPrice = 0;

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
