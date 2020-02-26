package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Checkout;

public class ScanningFixedPriceProducts {

    @Test
    void totalPriceShouldBeItemPriceAAfterScanningItemCodeA() {
        final char itemCodeA = 'A';
        final int itemPriceA = 50;

        final Checkout checkout = new Checkout(itemCodeA, itemPriceA);

        final int totalPrice = checkout.scan(itemCodeA);

        assertThat(totalPrice).isEqualTo(itemPriceA);
    }
}
