package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.itemprocessing.ItemQualityProcessorFactory;
import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items = Arrays.stream(items)
                .map(item -> ItemQualityProcessorFactory.getItemProcessor(item).updateQuality(item))
                .toArray(count -> new Item[count]);
    }
}
