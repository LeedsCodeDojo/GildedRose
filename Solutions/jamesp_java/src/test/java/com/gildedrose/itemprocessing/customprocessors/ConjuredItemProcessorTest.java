package com.gildedrose.itemprocessing.customprocessors;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.customprocessors.ConjuredItemProcessor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static com.gildedrose.item.ItemConstants.CONJURED_MANA_CAKE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemProcessorTest {

    private ConjuredItemProcessor proc = new ConjuredItemProcessor();
    private Item unexpiredItem = new Item(CONJURED_MANA_CAKE, 5, 40);
    private Item expiredItem = new Item(CONJURED_MANA_CAKE, 0, 5);

    @Nested
    class conjuredItemsDecreaseInQualityTwiceAsFastAsNormalItems {
        @Test
        void subtractTwicePerDayWhenUnexpired() {
            Item resultItem = proc.getQualityModifierFunction().apply(unexpiredItem);
            assertEquals(unexpiredItem.quality - 2, resultItem.quality);
        }

        @Test
        void subtractFourPerDayWhenExpired() {
            Item resultItem = proc.getQualityModifierFunction().apply(expiredItem);
            assertEquals(expiredItem.quality - 4, resultItem.quality);
        }
    }
}