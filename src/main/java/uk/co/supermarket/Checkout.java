package uk.co.supermarket;

public final class Checkout {

    private Buyer buyer;

    private PricingCatalogue pricingCatalogue;

    public Checkout(PricingCatalogue pricingCatalogue, Buyer buyer) {
        this.pricingCatalogue = pricingCatalogue;
        this.buyer = buyer;
    }

    public void scan(char itemCode) {
        final int totalPrice = pricingCatalogue.priceOf(itemCode);

        buyer.receiveTotalPrice(totalPrice);
    }
}
