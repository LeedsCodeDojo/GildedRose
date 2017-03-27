package com.gildedrose;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.gildedrose.TextCharacterisationTest.generateTestTextData;

public class DataFilesGeneratorForCharacterisationTests {

    public static void main(String[] args) {
        generate100DaysOfTestData();
    }

    private static void generate100DaysOfTestData() {
        int days = 100;
        generateDaysFiles(days, "expected_text_" + days + "_days.txt");
    }

    private static void generateDaysFiles(int day, String resultFileToGenerate) {
        String output = generateTestTextData(day);
        Path generatePath = Paths.get("src/test/resources/", resultFileToGenerate);
        try {
            Files.write(generatePath, output.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
