package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s224830206";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Hirusha Rukmal Hewageeganage";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Act
        int nHours = wController.getTotalHours();
        double minTemperature = 1000;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        // Assert
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);

        wController.close();
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Act
        int nHours = wController.getTotalHours();
        double maxTemperature = -1;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        // Assert
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);

        wController.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Act
        int nHours = wController.getTotalHours();
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / nHours;

        // Assert
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);

        wController.close();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Act
        String persistTime = wController.persistTemperature(10, 19.5);
        System.out.println("Persist time: " + persistTime);

        // Assert
        Assert.assertNotNull("Persist time should not be null", persistTime);
        Assert.assertTrue(
                "Persist time should match H:m:s format",
                persistTime.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")
        );

        wController.close();
    }
}