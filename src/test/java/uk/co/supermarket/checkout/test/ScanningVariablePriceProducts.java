package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Buyer;
import uk.co.supermarket.Checkout;
import uk.co.supermarket.PricingCatalogue;

public final class ScanningVariablePriceProducts {

    @Test
    void totalPriceShouldBeCataloguedPriceAfterScanningCataloguedItem() {
        final char cataloguedItemCode = 'B';
        final int cataloguedItemPrice = 30;

        final PricingCatalogue pricingCatalogue = new PricingCatalogue(cataloguedItemCode, cataloguedItemPrice);

        final Checkout checkout = new Checkout(pricingCatalogue);

        final int totalPrice = checkout.scan(cataloguedItemCode);

        assertThat(totalPrice).isEqualTo(cataloguedItemPrice);
    }

    @Test
    void totalPriceShouldBeObtainableAfterScanningAnItem() {
        final char cataloguedItemCode = 'B';
        final int cataloguedItemPrice = 30;

        final PricingCatalogue pricingCatalogue = new PricingCatalogue(cataloguedItemCode, cataloguedItemPrice);

        final Checkout checkout = new Checkout(pricingCatalogue);

        checkout.scan(cataloguedItemCode);

        assertThat(checkout.getTotalPrice()).isEqualTo(cataloguedItemPrice);
    }

    @Test
    void totalPriceShouldBePriceOfLastScannedItemAfterScanningTwoCataloguedItems() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        final char itemCodeA = 'A';
        final char itemPriceA = 50;

        pricingCatalogue.addItem(itemCodeA, itemPriceA);

        final char itemCodeB = 'B';
        final char itemPriceB = 30;

        pricingCatalogue.addItem(itemCodeB, itemPriceB);

        final Checkout checkout = new Checkout(pricingCatalogue);

        int totalPrice = checkout.scan(itemCodeA);
        assertThat(totalPrice).isEqualTo(itemPriceA);

        totalPrice = checkout.scan(itemCodeB);
        assertThat(totalPrice).isEqualTo(itemPriceB);
    }

    @Test
    void buyerShouldReceiveTheExpectedTotalPriceAfterScanningOneItem() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        final char itemCodeA = 'A';
        final char itemPriceA = 50;

        pricingCatalogue.addItem(itemCodeA, itemPriceA);

        Buyer buyer = mock(Buyer.class);

        final Checkout checkout = new Checkout(pricingCatalogue);

        int totalPrice = checkout.scan(itemCodeA);

        verify(buyer).receiveTotalPrice(itemPriceA);
    }
}
