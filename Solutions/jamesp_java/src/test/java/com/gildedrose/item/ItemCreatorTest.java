package com.gildedrose.item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemCreatorTest {

    Item item = new Item("Cat hair", 14, 10);

    @Test
    void itemWithQuality() {
        int expectedQuality = 4;

        Item actual = ItemCreator.itemWithQuality(item, expectedQuality);

        assertEquals(expectedQuality, actual.quality);
        assertEquals(item.name, actual.name);
        assertEquals(item.sellIn, actual.sellIn);
    }

    @Test
    void itemWithDecrementedSellInValue() {
        int expectedSellIn = item.sellIn - 1;

        Item actual = ItemCreator.itemWithDecrementedSellInValue(item);

        assertEquals(expectedSellIn, actual.sellIn);
        assertEquals(item.name, actual.name);
        assertEquals(item.quality, actual.quality);
    }

}
