package org.codewithsitangshu.simple;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SoftAssertionsTest {

    @Test(dataProvider = "getData")
    public void test(List<String> actual) {

        List<String> expected = Arrays.asList("car","ball");
        List<String> expectedWithSameOrder = Arrays.asList("apple","car","ball");
        List<String> expectedWithAnyOrder = Arrays.asList("car","ball","apple");

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(actual).hasSizeGreaterThanOrEqualTo(2)
                    .hasSize(3)
                    .doesNotContain("cat")
                    .contains("car")
                    .containsAll(expected)
                    .containsExactly(expectedWithSameOrder.toArray(new String[expectedWithSameOrder.size()]))
                    .containsExactlyInAnyOrder(expectedWithAnyOrder.toArray(new String[expectedWithAnyOrder.size()]))
                    .containsExactlyElementsOf(expectedWithSameOrder)
                    .containsExactlyInAnyOrderElementsOf(expectedWithAnyOrder)
                    .allSatisfy(str -> assertThat(str.length()).isGreaterThanOrEqualTo(3));
        });
    }

    @DataProvider
    public Object[] getData(){
        return new Object[] {
                Arrays.asList("ball", "apple", "car")
        };
    }

}
