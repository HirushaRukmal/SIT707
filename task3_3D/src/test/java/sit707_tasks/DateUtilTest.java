package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Updated tests for 3.3D
 * Includes both Boundary Value Analysis and Equivalence Class Testing.
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s224830206";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Hirusha Rukmal";
        Assert.assertNotNull("Student name is null", studentName);
    }


    @Test
    public void testBoundary_MinDayIncrement() {
        DateUtil date = new DateUtil(1, 1, 2024);
        DateUtil next = date.nextDate();

        Assert.assertEquals(2, next.getDay());
        Assert.assertEquals(1, next.getMonth());
        Assert.assertEquals(2024, next.getYear());
    }

    @Test
    public void testBoundary_MinDayDecrementToPreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        DateUtil prev = date.previousDate();

        Assert.assertEquals(31, prev.getDay());
        Assert.assertEquals(12, prev.getMonth());
        Assert.assertEquals(2023, prev.getYear());
    }

    @Test
    public void testBoundary_MaxDay31IncrementToNextMonth() {
        DateUtil date = new DateUtil(31, 1, 2024);
        DateUtil next = date.nextDate();

        Assert.assertEquals(1, next.getDay());
        Assert.assertEquals(2, next.getMonth());
        Assert.assertEquals(2024, next.getYear());
    }

    @Test
    public void testBoundary_MaxDay30IncrementToNextMonth() {
        DateUtil date = new DateUtil(30, 6, 2024);
        DateUtil next = date.nextDate();

        Assert.assertEquals(1, next.getDay());
        Assert.assertEquals(7, next.getMonth());
        Assert.assertEquals(2024, next.getYear());
    }

    @Test
    public void testBoundary_LeapYearFeb29Increment() {
        DateUtil date = new DateUtil(29, 2, 2024);
        DateUtil next = date.nextDate();

        Assert.assertEquals(1, next.getDay());
        Assert.assertEquals(3, next.getMonth());
        Assert.assertEquals(2024, next.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testBoundary_InvalidDayBelowMinimum() {
        new DateUtil(0, 1, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testBoundary_InvalidMonthAboveMaximum() {
        new DateUtil(1, 13, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testBoundary_InvalidYearBelowMinimum() {
        new DateUtil(1, 1, 1699);
    }

    @Test
    public void testEC_D1_M2_Y1() {
        DateUtil date = new DateUtil(15, 1, 2023);
        DateUtil next = date.nextDate();

        Assert.assertEquals(16, next.getDay());
        Assert.assertEquals(1, next.getMonth());
        Assert.assertEquals(2023, next.getYear());
    }

    // D1: day 1-28, M1: 30-day month, Y1: non-leap year
    @Test
    public void testEC_D1_M1_Y1() {
         DateUtil date = new  DateUtil(15, 6, 2023);
         DateUtil prev = date.previousDate();

        Assert.assertEquals(14, prev.getDay());
        Assert.assertEquals(6, prev.getMonth());
        Assert.assertEquals(2023, prev.getYear());
    }

    @Test
    public void testEC_D1_M3_Y1() {
         DateUtil date = new  DateUtil(15, 2, 2023);
         DateUtil next = date.nextDate();

        Assert.assertEquals(16, next.getDay());
        Assert.assertEquals(2, next.getMonth());
        Assert.assertEquals(2023, next.getYear());
    }
    
    @Test
    public void testEC_D2_M3_Y2() {
         DateUtil date = new  DateUtil(29, 2, 2024);
         DateUtil prev = date.previousDate();

        Assert.assertEquals(28, prev.getDay());
        Assert.assertEquals(2, prev.getMonth());
        Assert.assertEquals(2024, prev.getYear());
    }

    @Test
    public void testEC_D3_M1_Y1() {
         DateUtil date = new  DateUtil(30, 6, 2023);
         DateUtil next = date.nextDate();

        Assert.assertEquals(1, next.getDay());
        Assert.assertEquals(7, next.getMonth());
        Assert.assertEquals(2023, next.getYear());
    }

    @Test
    public void testEC_D4_M2_Y1() {
         DateUtil date = new  DateUtil(31, 1, 2023);
         DateUtil prev = date.previousDate();

        Assert.assertEquals(30, prev.getDay());
        Assert.assertEquals(1, prev.getMonth());
        Assert.assertEquals(2023, prev.getYear());
    }


    @Test(expected = RuntimeException.class)
    public void testInvalidClass_31In30DayMonth() {
        new  DateUtil(31, 6, 2023);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidClass_29FebNonLeapYear() {
        new  DateUtil(29, 2, 2023);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidClass_30FebLeapYear() {
        new  DateUtil(30, 2, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidClass_YearAboveRange() {
        new  DateUtil(1, 1, 2025);
    }


    @Test
    public void testIsLeapYearTrue() {
        Assert.assertTrue( DateUtil.isLeapYear(2024));
    }

    @Test
    public void testIsLeapYearFalse() {
        Assert.assertFalse( DateUtil.isLeapYear(2023));
    }

    @Test
    public void testDaysInMonthFebruaryLeapYear() {
        Assert.assertEquals(29,  DateUtil.daysInMonth(2, 2024));
    }

    @Test
    public void testDaysInMonthFebruaryNonLeapYear() {
        Assert.assertEquals(28,  DateUtil.daysInMonth(2, 2023));
    }

    @Test
    public void testDaysInMonthThirtyDayMonth() {
        Assert.assertEquals(30,  DateUtil.daysInMonth(6, 2023));
    }

    @Test
    public void testDaysInMonthThirtyOneDayMonth() {
        Assert.assertEquals(31,  DateUtil.daysInMonth(1, 2023));
    }
}