package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.customprocessors.BackStagePassQualityProcessor;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import static com.gildedrose.item.ItemConstants.BACKSTAGE_PASSES;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackStagePassQualityProcessorTest {

    private BackStagePassQualityProcessor processor = new BackStagePassQualityProcessor();

    @Test
    void qualityIncreasesBy1WhenSellInIsGreaterThan10() {
        Item item = new Item(BACKSTAGE_PASSES, 11, 40);
        Item resultItem = processor.getQualityModifierFunction().apply(item);
        assertEquals(41, resultItem.quality);
    }

    @Test
    void qualityIncreasesBy2WhenSellInIsGreaterThan5AndLessThanOrEqualTo10() {
        IntStream.rangeClosed(6, 10).forEach(sellIn -> {
            Item item = new Item(BACKSTAGE_PASSES, sellIn, 40);
            Item resultItem = processor.getQualityModifierFunction().apply(item);
            assertEquals(42, resultItem.quality);
        });
    }

    @Test
    void qualityIncreasesBy3WhenSellInIsGreaterThan0AndLessThanOrEqualTo5() {
        IntStream.rangeClosed(1, 5).forEach(sellIn -> {
            Item item = new Item(BACKSTAGE_PASSES, sellIn, 40);
            Item resultItem = processor.getQualityModifierFunction().apply(item);
            assertEquals(43, resultItem.quality);
        });
    }

    @Test
    void qualityIs0WhenSellInIs0OrLess() {
        IntStream.rangeClosed(-3, 0).forEach(sellIn -> {
            Item item = new Item(BACKSTAGE_PASSES, sellIn, 40);
            Item resultItem = processor.getQualityModifierFunction().apply(item);
            assertEquals(0, resultItem.quality);
        });
    }
}