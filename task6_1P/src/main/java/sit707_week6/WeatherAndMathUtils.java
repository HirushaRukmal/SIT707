package sit707_week6;

public class WeatherAndMathUtils {

    private static final double DANGEROUS_WIND_SPEED = 70.0;
    private static final double CONCERNING_WIND_SPEED = 45.0;
    private static final double DANGEROUS_RAINFALL = 6.0;
    private static final double CONCERNING_RAINFALL = 4.0;

    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException("Wind speed and precipitation must be non-negative.");
        }

        String advice = "ALL CLEAR";

        if (windSpeed > DANGEROUS_WIND_SPEED
                || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WIND_SPEED && precipitation > CONCERNING_RAINFALL)) {
            advice = "CANCEL";
        } else if (windSpeed > CONCERNING_WIND_SPEED
                || precipitation > CONCERNING_RAINFALL) {
            advice = "WARN";
        }

        return advice;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}