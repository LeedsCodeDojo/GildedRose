package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemQualityProcessorFactoryTest {

    @Test
    void whenPassedSulfuras_SellInFunctionIsANoOp() {
        int initialSellIn = 14;
        Item sulfuras = new Item(ItemConstants.SULFURAS, initialSellIn, 40);

        Item resultItem = ItemQualityProcessorFactory.getItemProcessor(sulfuras).updateQuality(sulfuras);

        assertEquals(initialSellIn, resultItem.sellIn);
    }

    @Test
    void whenPassedOtherItems_SellInFunctionDecreasesByOneOnUpdateQuality() {
        int initialSellIn = 14;
        Item brie = new Item(ItemConstants.AGED_BRIE, initialSellIn, 40);
        Item resultItem = ItemQualityProcessorFactory.getItemProcessor(brie).updateQuality(brie);

        assertEquals(initialSellIn - 1, resultItem.sellIn);
    }
}