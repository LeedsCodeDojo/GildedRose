package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.customprocessors.AgedBrieQualityProcessor;
import com.gildedrose.itemprocessing.customprocessors.BackStagePassQualityProcessor;
import com.gildedrose.itemprocessing.customprocessors.ConjuredItemProcessor;
import com.gildedrose.itemprocessing.customprocessors.SulfurasQualityProcessor;
import java.util.HashMap;
import java.util.Map;
import static com.gildedrose.item.ItemConstants.*;

public class ItemQualityProcessorFactory {

    private static final Map<String, ItemQualityProcessor> itemProcessorMap;
    private static final ItemQualityProcessor defaultProcessor = new DefaultItemQualityProcessor();

    static {
        itemProcessorMap = new HashMap<>();
        itemProcessorMap.put(AGED_BRIE, new AgedBrieQualityProcessor());
        itemProcessorMap.put(BACKSTAGE_PASSES, new BackStagePassQualityProcessor());
        itemProcessorMap.put(SULFURAS, new SulfurasQualityProcessor());
        itemProcessorMap.put(CONJURED_MANA_CAKE, new ConjuredItemProcessor());
    }

    public static ItemQualityProcessor getItemProcessor(Item item) {
        return itemProcessorMap.getOrDefault(item.name, defaultProcessor);
    }
}
