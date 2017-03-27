package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.customprocessors.SulfurasQualityProcessor;
import org.junit.jupiter.api.Test;

import static com.gildedrose.item.ItemConstants.SULFURAS;
import static org.junit.Assert.*;

class SulfurasQualityProcessorTest {

    SulfurasQualityProcessor processor = new SulfurasQualityProcessor();

    @Test
    void qualityIs80() {
        Item unexpiredItem = new Item(SULFURAS, 14, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(unexpiredItem);
        assertEquals(80, resultItem.quality);
    }

    @Test
    void qualityIs80EvenWhenExpired() {
        Item expiredItem = new Item(SULFURAS, -14, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(expiredItem);
        assertEquals(80, resultItem.quality);
    }

    @Test
    void sellInDoesNotIncreaseOrDecrease() {
        Item item = new Item(SULFURAS, 14, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(item);
        assertEquals(item.sellIn, resultItem.sellIn);
    }
}
