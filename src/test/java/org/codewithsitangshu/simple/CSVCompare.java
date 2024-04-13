package org.codewithsitangshu.simple;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVCompare {

    @Test
    public void compareFiles() {
        File actualFile = Paths.get("src/test/resources/data1.csv").toFile();
        File expectedFile = Paths.get("src/test/resources/data2.csv").toFile();

        assertThat(actualFile)
                .exists() // Verify that actualFile exists
                .isFile() // Verify that actualFile is a regular file
                .hasSameTextualContentAs(expectedFile); // Verify that actualFile has the same content as expectedFile
    }

    @Test
    public void compareCVS() throws IOException {
        List<String > actual = Files.readAllLines(Paths.get("src/test/resources/data1.csv"));
        List<String > expected = Files.readAllLines(Paths.get("src/test/resources/data2.csv"));

        assertThat(actual).containsAll(expected);
        assertThat(actual)
                .containsExactlyInAnyOrderElementsOf(expected);
        assertThat(actual)
                .containsExactlyElementsOf(expected);
    }

}
