package org.codewithsitangshu.simple;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTest {

    @Test
    public void test() {

        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        // Those assert methods are part of AbstractLocalDateAssert
        assertThat(today)
                .isAfter(yesterday) // After Yesterday
                .isBefore(tomorrow) // Before tomorrow
                .hasMonthValue(4)
                .hasMonth(Month.APRIL)
                .hasYear(2024)
                .hasDayOfMonth(7);

        // Those assert methods are part of AbstractDateAssert
        Date date = new Date();
        assertThat(date).hasMonth(4)
                .hasDayOfMonth(7)
                .hasHourOfDay(15)
                .hasMinute(15);




    }


}
