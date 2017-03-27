package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class DefaultItemQualityProcessorTest {

    private ItemQualityProcessor defaultProcessor = new DefaultItemQualityProcessor();

    @Nested
    class whenUpdatingSellIn {
        @Test
        void defaultIsToDecrement() {
            Item item = new Item("Cat poison", 0, 1);
            Item resultItem = defaultProcessor.getQualityModifierFunction().apply(item);
            assertEquals(item.quality - 1, resultItem.quality);
        }
    }

    @Nested
    class whenUpdatingQuality {
        @Test
        void defaultIsToDecrementQualityBy1WhenNotExpired() {
            Item unexpiredItem = new Item("Socks", 14, 40);
            Item resultItem = defaultProcessor.getQualityModifierFunction().apply(unexpiredItem);
            assertEquals(unexpiredItem.quality - 1, resultItem.quality);
        }

        @Test
        void defaultIsToDecrementQualityBy2WhenExpired() {
            Item expiredItem = new Item("Old socks", 0, 40);
            Item resultItem = defaultProcessor.getQualityModifierFunction().apply(expiredItem);
            assertEquals(expiredItem.quality - 2, resultItem.quality);
        }

        @Test
        void qualityIsNeverNegative() {
            Item item = new Item("Pigeon legs", -1, -10);
            Item resultItem = defaultProcessor.getQualityModifierFunction().apply(item);
            assertTrue(resultItem.quality >= 0);
        }

        @Test
        void qualityIsNeverMoreThan50() {
            Item item = new Item("Dog's eye holes", -1, 60);
            Item resultItem = defaultProcessor.getQualityModifierFunction().apply(item);
            assertTrue(resultItem.quality <= 50);
        }
    }
}

