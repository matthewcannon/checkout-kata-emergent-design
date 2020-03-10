package uk.co.supermarket.checkout.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Buyer;
import uk.co.supermarket.Checkout;
import uk.co.supermarket.PricingCatalogue;

public final class ScanningVariablePriceProducts {

    @Test
    void buyerShouldReceiveTheExpectedTotalPriceAfterScanningOneItem() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        final char itemCodeA = 'A';
        final char itemPriceA = 50;

        pricingCatalogue.addItem(itemCodeA, itemPriceA);

        Buyer buyer = mock(Buyer.class);

        final Checkout checkout = new Checkout(pricingCatalogue, buyer);

        checkout.scan(itemCodeA);

        verify(buyer).receiveTotalPrice(itemPriceA);
    }

    @Test
    void totalPriceShouldBePriceOfLastScannedItemAfterScanningCataloguedItems() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        final char itemCodeA = 'A';
        final char itemPriceA = 50;
        pricingCatalogue.addItem(itemCodeA, itemPriceA);

        final char itemCodeB = 'B';
        final char itemPriceB = 30;
        pricingCatalogue.addItem(itemCodeB, itemPriceB);

        Buyer buyer = mock(Buyer.class);

        final Checkout checkout = new Checkout(pricingCatalogue, buyer);

        checkout.scan(itemCodeA);

        verify(buyer).receiveTotalPrice(itemPriceA);

        reset(buyer);

        checkout.scan(itemCodeB);

        verify(buyer).receiveTotalPrice(itemPriceB);
    }
}
