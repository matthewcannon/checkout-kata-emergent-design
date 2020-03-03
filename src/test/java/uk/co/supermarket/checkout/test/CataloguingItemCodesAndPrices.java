package uk.co.supermarket.checkout.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import uk.co.supermarket.PricingCatalogue;

public class CataloguingItemCodesAndPrices {

    @Test
    void catalogueShouldKnowThePriceOfOneItem() {
        final PricingCatalogue pricingCatalogue = new PricingCatalogue();

        char cataloguedItemCode = 'A';
        int cataloguedItemPrice = 50;

        pricingCatalogue.addItem(cataloguedItemCode, cataloguedItemPrice);

        final int priceOfItemInCatalogue = pricingCatalogue.priceOf(cataloguedItemCode);

        assertThat(priceOfItemInCatalogue).isEqualTo(cataloguedItemPrice);
    }
}
