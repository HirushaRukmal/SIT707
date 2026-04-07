package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static double[] localTemperatures;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("=== setUpClass ===");

		// Arrange: initialise controller only once
		wController = WeatherController.getInstance();

		// Arrange: retrieve all hourly temperatures once and reuse them
		int nHours = wController.getTotalHours();
		localTemperatures = new double[nHours];

		for (int i = 0; i < nHours; i++) {
			localTemperatures[i] = wController.getTemperatureForHour(i + 1);
			System.out.println("Hour " + (i + 1) + " temperature = " + localTemperatures[i]);
		}
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("=== tearDownClass ===");

		// After: close controller only once
		if (wController != null) {
			wController.close();
		}
	}

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
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		// Arrange
		double minTemperature = localTemperatures[0];
		for (int i = 1; i < localTemperatures.length; i++) {
			if (minTemperature > localTemperatures[i]) {
				minTemperature = localTemperatures[i];
			}
		}

		// Act
		double cachedMin = wController.getTemperatureMinFromCache();

		// Assert
		Assert.assertEquals(minTemperature, cachedMin, 0.0001);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		// Arrange
		double maxTemperature = localTemperatures[0];
		for (int i = 1; i < localTemperatures.length; i++) {
			if (maxTemperature < localTemperatures[i]) {
				maxTemperature = localTemperatures[i];
			}
		}

		// Act
		double cachedMax = wController.getTemperatureMaxFromCache();

		// Assert
		Assert.assertEquals(maxTemperature, cachedMax, 0.0001);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		// Arrange
		double sumTemp = 0;
		for (int i = 0; i < localTemperatures.length; i++) {
			sumTemp += localTemperatures[i];
		}
		double averageTemp = sumTemp / localTemperatures.length;

		// Act
		double cachedAverage = wController.getTemperatureAverageFromCache();

		// Assert
		Assert.assertEquals(averageTemp, cachedAverage, 0.0001);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}