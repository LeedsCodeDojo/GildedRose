package com.gildedrose.item;

public class ItemCreator {

    public static Item itemWithQuality(Item i, int q) {
        return new Item(i.name, i.sellIn, q);
    }

    public static Item itemWithDecrementedSellInValue(Item i) {
        return new Item(i.name, i.sellIn - 1, i.quality);
    }
}
