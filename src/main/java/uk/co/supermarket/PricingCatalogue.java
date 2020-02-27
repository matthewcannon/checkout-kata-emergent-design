package uk.co.supermarket;

public class PricingCatalogue {

    private char itemCode;

    private int itemPrice;

    public PricingCatalogue(char itemCode, int itemPrice) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
    }

    public int priceOf(char itemCode) {
        if (itemCode == this.itemCode) {
            return this.itemPrice;
        }

        return 0;
    }
}
