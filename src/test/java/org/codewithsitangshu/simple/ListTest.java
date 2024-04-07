package org.codewithsitangshu.simple;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test(dataProvider = "getData")
    public void test(List<String> actual) {

        List<String> expected = Arrays.asList("car","ball");

        assertThat(actual)
                .hasSizeGreaterThanOrEqualTo(2) // Size of the list
                .hasSize(3) // validate exact size
                .doesNotContain("cat") // validate it should not contain cat
                .contains("car") // should contain car as one element
                .containsAll(expected) //should contain all element of expected list
                .allSatisfy(str -> assertThat(str.length()).isGreaterThanOrEqualTo(3)); // satisfy for all elements


    }

    @DataProvider
    public Object[] getData(){
        return new Object[] {
                Arrays.asList("ball", "apple", "car")
        };
    }



}
