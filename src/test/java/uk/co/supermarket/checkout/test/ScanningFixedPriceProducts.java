package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.Checkout;

public class ScanningFixedPriceProducts {

    @Test
    void totalPriceShouldBe50AfterScanningItemCodeA() {
        final Checkout checkout = new Checkout();

        final int totalPrice = checkout.scan('A');

        assertThat(totalPrice).isEqualTo(50);
    }
}
