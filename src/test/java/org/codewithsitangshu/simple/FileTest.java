package org.codewithsitangshu.simple;

import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    @Test
    public void verifyFileProperties() {
        File actualFile = Paths.get("src/test/resources/file1.txt").toFile();
        assertThat(actualFile)
                .canRead() // Verify that file1 is readable
                .canWrite() // Verify that file1 is writable
                .hasName("file1.txt") // Verify the name of file1
                .hasExtension("txt") // Verify the extension of file1
                .hasParent("src/test/resources"); // Verify the parent directory of file1
    }

    @Test
    public void compareFiles() {
        File actualFile = Paths.get("src/test/resources/file1.txt").toFile();
        File expectedFile = Paths.get("src/test/resources/file2.txt").toFile();

        assertThat(actualFile)
                .exists() // Verify that actualFile exists
                .isFile() // Verify that actualFile is a regular file
                .hasSameTextualContentAs(expectedFile); // Verify that actualFile has the same content as expectedFile
    }

}
