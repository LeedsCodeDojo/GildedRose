package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.DefaultItemQualityProcessor;
import java.util.function.UnaryOperator;
import static com.gildedrose.item.ItemCreator.itemWithQuality;

public class BackStagePassQualityProcessor extends DefaultItemQualityProcessor {

    @Override
    public UnaryOperator<Item> getCustomQualityModifierFunction() {
        return (item) -> INCREMENT_QUALITY
                .andThen(WHEN_SELL_IN_IS_10_DAYS_OR_LESS_THEN_INCREMENT_QUALITY)
                .andThen(WHEN_SELL_IN_IS_5_DAYS_OR_LESS_THEN_INCREMENT_QUALITY)
                .andThen(WHEN_SELL_IS_0_OR_LESS_QUALITY_IS_0)
                .apply(item);
    }

    private static final UnaryOperator<Item> WHEN_SELL_IS_0_OR_LESS_QUALITY_IS_0
            = item -> item.sellIn <= 0 ? itemWithQuality(item, 0) : item;

    private static final UnaryOperator<Item> WHEN_SELL_IN_IS_10_DAYS_OR_LESS_THEN_INCREMENT_QUALITY
            = item -> item.sellIn <= 10 ? INCREMENT_QUALITY.apply(item) : item;

    private static final UnaryOperator<Item> WHEN_SELL_IN_IS_5_DAYS_OR_LESS_THEN_INCREMENT_QUALITY
            = item -> item.sellIn <= 5 ? INCREMENT_QUALITY.apply(item) : item;

}