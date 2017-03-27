package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.DefaultItemQualityProcessor;
import java.util.function.UnaryOperator;
import static com.gildedrose.item.ItemCreator.itemWithQuality;

public class ConjuredItemProcessor extends DefaultItemQualityProcessor {

    @Override
    public UnaryOperator<Item> getCustomQualityModifierFunction() {
        return (item) -> WHEN_QUALITY_WHEN_GREATER_THAN_0_THEN_DECREMENT_BY_2
                .andThen(WHEN_SELL_IN_IS_0_OR_LESS_THEN_DECREMENT_QUALITY_BY_2)
                .apply(item);
    }

    UnaryOperator<Item> WHEN_QUALITY_WHEN_GREATER_THAN_0_THEN_DECREMENT_BY_2
            = item -> item.quality > 0 ? itemWithQuality(item, item.quality - 2) : item;

    UnaryOperator<Item> WHEN_SELL_IN_IS_0_OR_LESS_THEN_DECREMENT_QUALITY_BY_2
            = item -> item.sellIn <= 0 ? itemWithQuality(item, item.quality - 2) : item;
}