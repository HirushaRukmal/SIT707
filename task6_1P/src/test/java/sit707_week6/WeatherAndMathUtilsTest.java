package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

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
     * weatherAdvice tests
     */

    @Test
    public void testDangerousWeather_WindAbove70() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testDangerousWeather_RainAbove6() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
    }

    @Test
    public void testDangerousWeather_WindAbove45AndRainAbove4() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWarningWeather_WindAbove45Only() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWarningWeather_RainAbove4Only() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.5));
    }

    @Test
    public void testAllClearWeather_NormalConditions() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }

    @Test
    public void testAllClearWeather_AtThresholds() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdvice_InvalidNegativeWind() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdvice_InvalidNegativeRain() {
        WeatherAndMathUtils.weatherAdvice(10.0, -0.1);
    }

    /*
     * isEven tests
     */

    @Test
    public void testIsEven_PositiveEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(8));
    }

    @Test
    public void testIsEven_PositiveOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(7));
    }

    @Test
    public void testIsEven_Zero() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }

    @Test
    public void testIsEven_NegativeEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-4));
    }

    @Test
    public void testIsEven_NegativeOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
    }

    /*
     * isPrime tests
     */

    @Test
    public void testIsPrime_Two() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrime_PrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(13));
    }

    @Test
    public void testIsPrime_CompositeNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(12));
    }

    @Test
    public void testIsPrime_One() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testIsPrime_Zero() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
    }

    @Test
    public void testIsPrime_NegativeNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-7));
    }
}