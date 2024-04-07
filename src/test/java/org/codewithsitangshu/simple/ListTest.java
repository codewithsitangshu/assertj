package org.codewithsitangshu.simple;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test(dataProvider = "getData")
    public void test(List<String> actual) {

        List<String> expected = Arrays.asList("car","ball");
        List<String> expectedWithSameOrder = Arrays.asList("ball","apple","car");
        List<String> expectedWithAnyOrder = Arrays.asList("car","ball","apple");

        assertThat(actual)
                .hasSizeGreaterThanOrEqualTo(2) // Size of the list
                .hasSize(3) // validate exact size
                .doesNotContain("cat") // validate it should not contain cat
                .contains("car") // should contain car as one element
                .containsAll(expected) //should contain all element of expected list
                .containsExactly(expectedWithSameOrder.toArray(new String[expectedWithSameOrder.size()]))
                .containsExactlyInAnyOrder(expectedWithAnyOrder.toArray(new String[expectedWithAnyOrder.size()]))
                .containsExactlyElementsOf(expectedWithSameOrder)
                .containsExactlyInAnyOrderElementsOf(expectedWithAnyOrder)
                .allSatisfy(str -> assertThat(str.length()).isGreaterThanOrEqualTo(3)); // satisfy for all elements


    }

    @DataProvider
    public Object[] getData(){
        return new Object[] {
                Arrays.asList("ball", "apple", "car")
        };
    }



}
