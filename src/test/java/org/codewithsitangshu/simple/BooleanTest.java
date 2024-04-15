package org.codewithsitangshu.simple;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanTest {

    @Test
    public void test() {
        boolean actual = true;
        assertThat(actual).isTrue();
        assertThat(actual).isEqualTo(true);
        assertThat(actual).withFailMessage("Value is not false")
                .isFalse();
    }

}
