package net.lkrnac.blog.validatedate;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

public class DateValidationTest {
    @Test
    public void validateDateTime() {
        //GIVEN
        LocalDateTime expectedDateTime = LocalDateTime.now();

        //WHEN
        LocalDateTime actualDateTime = LocalDateTime.now();

        //THEN
        assertThat(actualDateTime, LocalDateTimeMatchers.within(2, ChronoUnit.SECONDS, expectedDateTime));
    }

    @Test
    public void validateInstant() {
        //GIVEN
        ZonedDateTime expectedDateTime = ZonedDateTime.of(2016, 3, 20, 13, 3, 0, 0, ZoneId.of("GMT+1"));

        //WHEN
        ZonedDateTime actualDateTime = ZonedDateTime.of(2016, 3, 20, 13, 3, 0, 0, ZoneId.of("GMT-0"));

        //THEN
        assertThat(actualDateTime, ZonedDateTimeMatchers.sameDay(expectedDateTime));
        assertThat(actualDateTime, ZonedDateTimeMatchers.after(expectedDateTime));
        assertThat(actualDateTime, ZonedDateTimeMatchers.isSunday());
        assertThat(actualDateTime, ZonedDateTimeMatchers.isMarch());
    }

    @Test
    public void validateDate() {
        //GIVEN
        Date expectedDate = new Date();

        //WHEN
        Date actualDate = new Date();

        //THEN
        assertThat(actualDate, DateMatchers.within(2, ChronoUnit.SECONDS, expectedDate));
    }
}
