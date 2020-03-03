package uk.co.supermarket;

public class PricingCatalogue {

    private char itemCode;

    private int itemPrice;

    public PricingCatalogue(char itemCode, int itemPrice) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
    }

    public PricingCatalogue() {
    }

    public int priceOf(char itemCode) {
        if (itemCode == this.itemCode) {
            return itemPrice;
        }

        return 0;
    }

    public void addItem(char itemCode, int itemPrice) {
    }
}
