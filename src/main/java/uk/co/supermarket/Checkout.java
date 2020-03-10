package uk.co.supermarket;

public final class Checkout {

    private Buyer buyer;

    private PricingCatalogue pricingCatalogue;

    private int totalPrice = 0;

    public Checkout(PricingCatalogue pricingCatalogue) {
        this.pricingCatalogue = pricingCatalogue;
        buyer = new NullBuyer();
    }

    public Checkout(PricingCatalogue pricingCatalogue, Buyer buyer) {
        this(pricingCatalogue);
        this.buyer = buyer;
    }

    public void scan(char itemCode) {
        totalPrice = pricingCatalogue.priceOf(itemCode);

        buyer.receiveTotalPrice(totalPrice);
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
