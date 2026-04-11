package sit707_week6;

public class LoopCoverageUtils {

    // Part B(a): conditional loop with simple instructions
    public static int sumArray(int[] numbers) {
        int sum = 0;
        int i = 0;

        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }

        return sum;
    }

    // Part B(b): conditional loop with conditional statement in loop body
    public static int countPositiveEvenNumbers(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}