package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TextCharacterisationTest {

    private static final String LS = System.lineSeparator();

    @Test
    public void runCharacteristicTestFor100Days() {
        String expected = generateTestTextData(100);
        Path expectedContentFilePath = Paths.get("src/test/resources/expected_text_100_days.txt");
        try {
            assertEquals(new String(Files.readAllBytes(expectedContentFilePath)), expected,
                    "Failed whilst testing file: " + expectedContentFilePath.toAbsolutePath());
        } catch (IOException ex) {
            fail("Unexpected Exception reading file");
        }
    }

    public static String generateTestTextData(int days) {
        StringBuilder str = new StringBuilder();

        str.append("OMGHAI!" + LS);

        Item[] items = getItems();
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            str.append("-------- day " + i + " --------" + LS);
            str.append("name, sellIn, quality" + LS);
            for (Item item : app.items) {
                str.append(item + LS);
            }
            str.append(LS);
            app.updateQuality();
        }
        return str.toString();
    }

    public static Item[] getItems() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }
}
