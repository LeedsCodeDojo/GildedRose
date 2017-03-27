package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemCreator;
import java.util.function.UnaryOperator;
import static com.gildedrose.item.ItemCreator.itemWithQuality;

public class DefaultItemQualityProcessor implements ItemQualityProcessor {

    public final UnaryOperator<Item> getSellInFunction() {
        return ItemCreator::itemWithDecrementedSellInValue;
    }

    public final UnaryOperator<Item> getQualityModifierFunction() {
        return (item) -> getCustomQualityModifierFunction()
                .andThen(QUALITY_IS_NEVER_NEGATIVE)
                .andThen(MAX_QUALITY_IS_50)
                .apply(item);
    }

    public UnaryOperator<Item> getCustomQualityModifierFunction() {
        return (item) -> WHEN_QUALITY_WHEN_GREATER_THAN_0_THEN_DECREMENT
                .andThen(WHEN_SELL_IN_IS_0_OR_LESS_THEN_DECREMENT_QUALITY)
                .apply(item);
    }


    private static final UnaryOperator<Item> QUALITY_IS_NEVER_NEGATIVE =
            item -> item.quality < 0 ? itemWithQuality(item, 0) : item;

    private static final UnaryOperator<Item> MAX_QUALITY_IS_50 =
            item -> item.quality > 50 ? itemWithQuality(item, 50) : item;

}
