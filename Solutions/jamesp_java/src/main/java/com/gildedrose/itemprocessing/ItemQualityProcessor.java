package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import java.util.function.UnaryOperator;
import static com.gildedrose.item.ItemCreator.itemWithQuality;

public interface ItemQualityProcessor {

    UnaryOperator<Item> INCREMENT_QUALITY = item -> itemWithQuality(item, item.quality + 1);

    UnaryOperator<Item> DECREMENT_QUALITY = item -> itemWithQuality(item, item.quality - 1);

    UnaryOperator<Item> WHEN_QUALITY_WHEN_GREATER_THAN_0_THEN_DECREMENT
            = item -> item.quality > 0 ? DECREMENT_QUALITY.apply(item) : item;

    UnaryOperator<Item> WHEN_SELL_IN_IS_0_OR_LESS_THEN_DECREMENT_QUALITY
            = item -> item.sellIn <= 0 ? WHEN_QUALITY_WHEN_GREATER_THAN_0_THEN_DECREMENT.apply(item) : item;

    default Item updateQuality(Item item) {
        return getQualityModifierFunction()
                .andThen(getSellInFunction())
                .apply(item);
    }

    UnaryOperator<Item> getSellInFunction();

    UnaryOperator<Item> getQualityModifierFunction();

}