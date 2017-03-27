package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.ItemQualityProcessor;
import java.util.function.UnaryOperator;
import static com.gildedrose.item.ItemCreator.itemWithQuality;

public class SulfurasQualityProcessor implements ItemQualityProcessor {

    @Override
    public UnaryOperator<Item> getSellInFunction() {
        return (item) -> item;
    }

    @Override
    public UnaryOperator<Item> getQualityModifierFunction() {
        return (item) -> itemWithQuality(item, 80);
    }
}
