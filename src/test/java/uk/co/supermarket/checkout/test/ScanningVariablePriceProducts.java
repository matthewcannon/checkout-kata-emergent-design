package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Buyer;
import uk.co.supermarket.Checkout;
import uk.co.supermarket.PricingCatalogue;

public final class ScanningVariablePriceProducts implements Buyer {

    private int totalPriceReceived;

    @Test
    void totalPriceReceivedShouldBePriceOfLastScannedItemWhenScanningTwoCataloguedItems() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        final char itemCodeA = 'A';
        final char itemPriceA = 50;
        pricingCatalogue.addItem(itemCodeA, itemPriceA);

        final char itemCodeB = 'B';
        final char itemPriceB = 30;
        pricingCatalogue.addItem(itemCodeB, itemPriceB);

        final Buyer buyer = selfAsBuyer();

        final Checkout checkout = new Checkout(pricingCatalogue, buyer);

        checkout.scan(itemCodeA);

        assertThat(totalPriceReceived).isEqualTo(itemPriceA);

        checkout.scan(itemCodeB);

        assertThat(totalPriceReceived).isEqualTo(itemPriceB);
    }

    private Buyer selfAsBuyer() {
        return this;
    }

    @Override public void receiveTotalPrice(int totalPrice) {
        totalPriceReceived = totalPrice;
    }
}
