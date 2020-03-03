package uk.co.supermarket;

import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;

public class PricingCatalogue {

    private MutableCharIntMap items;

    public PricingCatalogue(char itemCode, int itemPrice) {
        this();
        addItem(itemCode, itemPrice);
    }

    public PricingCatalogue() {
        items = new CharIntHashMap();
    }

    public int priceOf(char itemCode) {
        return items.get(itemCode);
    }

    public void addItem(char itemCode, int itemPrice) {
        items.addToValue(itemCode, itemPrice);
    }
}
