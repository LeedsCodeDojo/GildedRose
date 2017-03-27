package com.gildedrose;

public class GildedRoseTest {   
    
    GildedRose app;
    /**
     * KEEPING THIS TO DEMONSTRATE THERE TESTS THAT WERE ORIGINALLY WRITTEN BUT THEN PLACED INTO RELEVANT CLASSES
     * AS I REFACTORED THE APP...
     */

    /* Moved to ItemQualityProcessor Test
    @Test
    public void whenUpdatingQuality_defaultIsToDecrementQualityAndSellIn() {
        app = initialiseAppWithItems(new Item("foo", 5, 10));
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    */
    /*
    @Test
    public void whenUpdatingQuality_qualityIsNeverNegative() {
        app = initialiseAppWithItems(getItems());
        assertPredicateAsTrueForNUpdates((item) -> item.quality >= 0, 500);
    }
    */  
    /*
    @Test
    public void whenUpdatingQuality_maxQualityIs50ExceptSulfuras() {
        app = initialiseAppWithItems(getItems());
        Predicate<Item> itemQualityNotAbove50 = i -> i.quality <= 50;
        Predicate<Item> itemIsSulfuras = i -> i.name.equals(SULFURAS);
        assertPredicateAsTrueForNUpdates(itemQualityNotAbove50.or(itemIsSulfuras), 500);
    }

    private void assertPredicateAsTrueForNUpdates(Predicate<Item> predicate, int times) {
        for (int i = 0; i < times; i++) {
            app.updateQuality();
            assertTrue(Arrays.stream(app.items).allMatch(predicate));
        }
    }

    private GildedRose initialiseAppWithItems(Item... items) {
        return new GildedRose(items);
    }
    */
    /* Moved to ItemQualityProcessor Test
    @Test
    public void whenSellInDaysHaveElapsed_defaultIsForQualityDegradesTwiceAsFast() {
        app = initialiseAppWithItems(new Item("foo", 0, 10));
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    */
    
    /* Moved to Aged Bire processor Test
    @Test
    public void whenUpdatingAgedBrie_qualityIncrementsWhenSellInIsGreaterThan0() {
        app = initialiseAppWithItems(new Item(AGED_BRIE, 1, 10));
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void whenUpdatingAgedBrie_qualityIncreasesBy2WhenSellInIsLessThanOrEqualTo0() {
        app = initialiseAppWithItems(new Item(AGED_BRIE, 0, 10));
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    */
    
    /* Moved to Sulfuras tests
    @Test
    public void whenUpdatingSulfuras_thenQualityDoesNotIncreaseOrDecrease() {
        app = initialiseAppWithItems(new Item(SULFURAS, 4, 40));
        app.updateQuality();
        assertEquals(40, app.items[0].quality);
    }
    
    @Test
    public void whenUpdatingSulfuras_thenSellInDoesNotIncreaseOrDecrease() {
        app = initialiseAppWithItems(new Item(SULFURAS, 4, 40));
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }
    */
    /* moved to backstage passes tests
    @Test
    public void whenUpdatingBackstagePasses_thenQualityIncreasesBy1WhenSellInIsGreaterThan10() {
        app = initialiseAppWithItems(new Item(BACKSTAGE_PASSES, 11, 40));
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }
    
    @Test
    public void whenUpdatingBackstagePasses_thenQualityIncreasesBy2WhenSellInIsGreaterThan5AndLessThanOrEqualTo10() {
        app = initialiseAppWithItems(
                new Item(BACKSTAGE_PASSES, 10, 40),
                new Item(BACKSTAGE_PASSES, 9, 40),
                new Item(BACKSTAGE_PASSES, 8, 40),
                new Item(BACKSTAGE_PASSES, 7, 40),
                new Item(BACKSTAGE_PASSES, 6, 40));
        app.updateQuality();
        assertTrue(Arrays.stream(app.items).allMatch(item -> item.quality == 42));
    }
    
    @Test
    public void whenUpdatingBackstagePasses_thenQualityIncreasesBy3WhenSellInIsGreaterThan0AndLessThanOrEqualTo5() {
        app = initialiseAppWithItems(
                new Item(BACKSTAGE_PASSES, 5, 40),
                new Item(BACKSTAGE_PASSES, 4, 40),
                new Item(BACKSTAGE_PASSES, 3, 40),
                new Item(BACKSTAGE_PASSES, 2, 40),
                new Item(BACKSTAGE_PASSES, 1, 40));
        app.updateQuality();
        assertTrue(Arrays.stream(app.items).allMatch(item -> item.quality == 43));
    }   
    
    @Test
    public void whenUpdatingBackstagePasses_thenQualityIs0WhenSellInIs0OrLess() {
        app = initialiseAppWithItems(
                new Item(BACKSTAGE_PASSES, 0, 40),
                new Item(BACKSTAGE_PASSES, -1, 40));
        app.updateQuality();
        assertTrue(Arrays.stream(app.items).allMatch(item -> item.quality == 0));
    }*/
}