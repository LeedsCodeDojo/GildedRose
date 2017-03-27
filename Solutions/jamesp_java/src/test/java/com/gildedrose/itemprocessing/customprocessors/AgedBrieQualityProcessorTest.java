package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.customprocessors.AgedBrieQualityProcessor;
import org.junit.jupiter.api.Test;
import static com.gildedrose.item.ItemConstants.AGED_BRIE;
import static org.junit.Assert.assertEquals;

class AgedBrieQualityProcessorTest {

    AgedBrieQualityProcessor processor = new AgedBrieQualityProcessor();

    @Test
    void qualityIncrementsWhenSellInIsGreaterThan0() {
        Item unexpiredItem = new Item(AGED_BRIE, 14, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(unexpiredItem);
        assertEquals(unexpiredItem.quality + 1, resultItem.quality);
    }

    @Test
    void qualityIncreasesBy2WhenSellInIsLessThanOrEqualTo0() {
        Item unexpiredItem = new Item(AGED_BRIE, 0, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(unexpiredItem);
        assertEquals(unexpiredItem.quality + 2, resultItem.quality);
    }
}