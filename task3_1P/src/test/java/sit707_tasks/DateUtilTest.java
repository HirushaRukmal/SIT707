package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.println("january31ShouldIncrementToFebruary1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.println("january31ShouldDecrementToJanuary30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
		System.out.println("testJanuaryNominal > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(rand_day_1_to_31 + 1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	/*
	 * Complete below test cases.
	 */

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);

		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);

		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	/*
	 * Write tests for rest months of year 2024.
	 */

	// Previous date tests from table A

	@Test
	public void testPreviousDate1A() {
		DateUtil date = new DateUtil(1, 6, 1994);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(5, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate2A() {
		DateUtil date = new DateUtil(2, 6, 1994);
		date.decrement();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate3A() {
		DateUtil date = new DateUtil(15, 6, 1994);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate4A() {
		DateUtil date = new DateUtil(30, 6, 1994);
		date.decrement();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void testPreviousDate5AInvalidJune31() {
		new DateUtil(31, 6, 1994);
	}

	@Test
	public void testPreviousDate6A() {
		DateUtil date = new DateUtil(15, 1, 1994);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate7A() {
		DateUtil date = new DateUtil(15, 2, 1994);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate8A() {
		DateUtil date = new DateUtil(15, 11, 1994);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(11, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate9A() {
		DateUtil date = new DateUtil(15, 12, 1994);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testPreviousDate10A() {
		DateUtil date = new DateUtil(15, 6, 1700);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testPreviousDate11A() {
		DateUtil date = new DateUtil(15, 6, 1701);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void testPreviousDate12A() {
		DateUtil date = new DateUtil(15, 6, 2023);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testPreviousDate13A() {
		DateUtil date = new DateUtil(15, 6, 2024);
		date.decrement();
		Assert.assertEquals(14, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	// Next date tests from table B

	@Test
	public void testNextDate1B() {
		DateUtil date = new DateUtil(1, 6, 1994);
		date.increment();
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate2B() {
		DateUtil date = new DateUtil(2, 6, 1994);
		date.increment();
		Assert.assertEquals(3, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate3B() {
		DateUtil date = new DateUtil(15, 6, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate4B() {
		DateUtil date = new DateUtil(30, 6, 1994);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void testNextDate5BInvalidJune31() {
		new DateUtil(31, 6, 1994);
	}

	@Test
	public void testNextDate6B() {
		DateUtil date = new DateUtil(15, 1, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate7B() {
		DateUtil date = new DateUtil(15, 2, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate8B() {
		DateUtil date = new DateUtil(15, 11, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(11, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate9B() {
		DateUtil date = new DateUtil(15, 12, 1994);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNextDate10B() {
		DateUtil date = new DateUtil(15, 6, 1700);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testNextDate11B() {
		DateUtil date = new DateUtil(15, 6, 1701);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void testNextDate12B() {
		DateUtil date = new DateUtil(15, 6, 2023);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testNextDate13B() {
		DateUtil date = new DateUtil(15, 6, 2024);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	// Leap year tests for February 2024

	@Test
	public void testLeapYearFeb28ShouldIncrementToFeb29() {
		DateUtil date = new DateUtil(28, 2, 2024);
		date.increment();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFeb29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMarch1ShouldDecrementToLeapYearFeb29() {
		DateUtil date = new DateUtil(1, 3, 2024);
		date.decrement();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
}