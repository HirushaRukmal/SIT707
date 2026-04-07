package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Equivalence class testing for DateUtil
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

	/*
	 * =========================
	 * VALID EQUIVALENCE CLASSES
	 * =========================
	 */

	// D1: Day between 1 and 28
	// M2: 31-day month
	// Y1: non-leap year
	@Test
	public void testD1_M2_Y1_IncrementNormal31DayMonth() {
		DateUtil date = new DateUtil(15, 1, 2023);
		date.increment();

		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD1_M2_Y1_DecrementNormal31DayMonth() {
		DateUtil date = new DateUtil(15, 1, 2023);
		date.decrement();

		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D1: Day between 1 and 28
	// M1: 30-day month
	// Y1: non-leap year
	@Test
	public void testD1_M1_Y1_IncrementNormal30DayMonth() {
		DateUtil date = new DateUtil(15, 6, 2023);
		date.increment();

		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD1_M1_Y1_DecrementNormal30DayMonth() {
		DateUtil date = new DateUtil(15, 6, 2023);
		date.decrement();

		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D1: Day between 1 and 28
	// M3: February
	// Y1: non-leap year
	@Test
	public void testD1_M3_Y1_IncrementNormalFebruaryNonLeap() {
		DateUtil date = new DateUtil(15, 2, 2023);
		date.increment();

		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD1_M3_Y1_DecrementNormalFebruaryNonLeap() {
		DateUtil date = new DateUtil(15, 2, 2023);
		date.decrement();

		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D2: Day = 29
	// M3: February
	// Y2: leap year
	@Test
	public void testD2_M3_Y2_LeapYearFeb29Increment() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();

		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testD2_M3_Y2_LeapYearFeb29Decrement() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.decrement();

		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	// D2: Day = 29
	// M1: 30-day month
	// Y1: non-leap year
	@Test
	public void testD2_M1_Y1_Day29In30DayMonthIncrement() {
		DateUtil date = new DateUtil(29, 6, 2023);
		date.increment();

		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D2: Day = 29
	// M2: 31-day month
	// Y1: non-leap year
	@Test
	public void testD2_M2_Y1_Day29In31DayMonthIncrement() {
		DateUtil date = new DateUtil(29, 1, 2023);
		date.increment();

		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D3: Day = 30
	// M1: 30-day month
	// Y1: non-leap year
	@Test
	public void testD3_M1_Y1_EndOf30DayMonthIncrement() {
		DateUtil date = new DateUtil(30, 6, 2023);
		date.increment();

		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD3_M1_Y1_EndOf30DayMonthDecrement() {
		DateUtil date = new DateUtil(30, 6, 2023);
		date.decrement();

		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D3: Day = 30
	// M2: 31-day month
	// Y1: non-leap year
	@Test
	public void testD3_M2_Y1_Day30In31DayMonthIncrement() {
		DateUtil date = new DateUtil(30, 1, 2023);
		date.increment();

		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D4: Day = 31
	// M2: 31-day month
	// Y1: non-leap year
	@Test
	public void testD4_M2_Y1_EndOf31DayMonthIncrement() {
		DateUtil date = new DateUtil(31, 1, 2023);
		date.increment();

		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD4_M2_Y1_EndOf31DayMonthDecrement() {
		DateUtil date = new DateUtil(31, 1, 2023);
		date.decrement();

		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// Year lower valid class
	@Test
	public void testValidLowerYearClass() {
		DateUtil date = new DateUtil(15, 6, 1700);
		date.increment();

		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1700, date.getYear());
	}

	// Year upper valid class
	@Test
	public void testValidUpperYearClass() {
		DateUtil date = new DateUtil(15, 6, 2024);
		date.decrement();

		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	/*
	 * ===========================
	 * INVALID EQUIVALENCE CLASSES
	 * ===========================
	 */

	// Invalid: D4 with M1 (31 in 30-day month)
	@Test(expected = RuntimeException.class)
	public void testInvalid_D4_M1_31In30DayMonth() {
		new DateUtil(31, 6, 2023);
	}

	// Invalid: D2 with M3 and Y1 (29 Feb in non-leap year)
	@Test(expected = RuntimeException.class)
	public void testInvalid_D2_M3_Y1_29FebNonLeapYear() {
		new DateUtil(29, 2, 2023);
	}

	// Invalid: D3 with M3 (30 Feb)
	@Test(expected = RuntimeException.class)
	public void testInvalid_D3_M3_30Feb() {
		new DateUtil(30, 2, 2024);
	}

	// Invalid: D4 with M3 (31 Feb)
	@Test(expected = RuntimeException.class)
	public void testInvalid_D4_M3_31Feb() {
		new DateUtil(31, 2, 2024);
	}

	// Invalid day below range
	@Test(expected = RuntimeException.class)
	public void testInvalidDayBelowRange() {
		new DateUtil(0, 1, 2024);
	}

	// Invalid day above range
	@Test(expected = RuntimeException.class)
	public void testInvalidDayAboveRange() {
		new DateUtil(32, 1, 2024);
	}

	// Invalid month below range
	@Test(expected = RuntimeException.class)
	public void testInvalidMonthBelowRange() {
		new DateUtil(15, 0, 2024);
	}

	// Invalid month above range
	@Test(expected = RuntimeException.class)
	public void testInvalidMonthAboveRange() {
		new DateUtil(15, 13, 2024);
	}

	// Invalid year below range
	@Test(expected = RuntimeException.class)
	public void testInvalidYearBelowRange() {
		new DateUtil(15, 6, 1699);
	}

	// Invalid year above range
	@Test(expected = RuntimeException.class)
	public void testInvalidYearAboveRange() {
		new DateUtil(15, 6, 2025);
	}
}