package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Checkout;
import uk.co.supermarket.PricingCatalogue;

public class ScanningFixedPriceProducts {

    @Test
    void totalPriceShouldBeItemPriceAAfterScanningItemCodeA() {
        final char itemCodeA = 'A';
        final int itemPriceA = 50;

        final Checkout checkout = new Checkout(itemCodeA, itemPriceA);

        final int totalPrice = checkout.scan(itemCodeA);

        assertThat(totalPrice).isEqualTo(itemPriceA);
    }

    @Test
    void totalPriceShouldBeItemPriceBAfterScanningItemCodeB() {
        final char itemCodeB = 'B';
        final int itemPriceB = 30;

        final Checkout checkout = new Checkout(' ', 0, itemCodeB, itemPriceB);

        final int totalPrice = checkout.scan(itemCodeB);

        assertThat(totalPrice).isEqualTo(itemPriceB);
    }

    @Test
    void totalPriceShouldBeCataloguedPriceAfterScanningCataloguedItem() {
        final char cataloguedItemCode = 'B';
        final int cataloguedItemPrice = 30;

        final PricingCatalogue pricingCatalogue = new PricingCatalogue(cataloguedItemCode, cataloguedItemPrice);

        final Checkout checkout = new Checkout(pricingCatalogue);

        final int totalPrice = checkout.scan(cataloguedItemCode);

        assertThat(totalPrice).isEqualTo(cataloguedItemPrice);
    }
}
