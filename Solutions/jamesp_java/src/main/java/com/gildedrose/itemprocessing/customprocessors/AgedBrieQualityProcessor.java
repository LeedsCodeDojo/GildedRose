package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.DefaultItemQualityProcessor;
import java.util.function.UnaryOperator;

public class AgedBrieQualityProcessor extends DefaultItemQualityProcessor {

    @Override
    public UnaryOperator<Item> getCustomQualityModifierFunction() {
        return (item) -> INCREMENT_QUALITY
                .andThen(WHEN_SELL_IN_IS_LESS_THAN_0_THEN_INCREMENT_QUALITY)
                .apply(item);
    }

    private static final UnaryOperator<Item> WHEN_SELL_IN_IS_LESS_THAN_0_THEN_INCREMENT_QUALITY
            = item -> item.sellIn <= 0 ? INCREMENT_QUALITY.apply(item) : item;

}
