package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopCoverageUtilsTest {

    /*
     * sumArray tests
     */

    @Test
    public void testSumArray_EmptyArray() {
        Assert.assertEquals(0, LoopCoverageUtils.sumArray(new int[] {}));
    }

    @Test
    public void testSumArray_SingleElement() {
        Assert.assertEquals(5, LoopCoverageUtils.sumArray(new int[] {5}));
    }

    @Test
    public void testSumArray_MultipleElements() {
        Assert.assertEquals(10, LoopCoverageUtils.sumArray(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void testSumArray_WithNegativeNumbers() {
        Assert.assertEquals(2, LoopCoverageUtils.sumArray(new int[] {5, -3, 0}));
    }

    /*
     * countPositiveEvenNumbers tests
     */

    @Test
    public void testCountPositiveEvenNumbers_EmptyArray() {
        Assert.assertEquals(0, LoopCoverageUtils.countPositiveEvenNumbers(new int[] {}));
    }

    @Test
    public void testCountPositiveEvenNumbers_NoMatches() {
        Assert.assertEquals(0, LoopCoverageUtils.countPositiveEvenNumbers(new int[] {1, 3, -2, -4}));
    }

    @Test
    public void testCountPositiveEvenNumbers_AllMatches() {
        Assert.assertEquals(3, LoopCoverageUtils.countPositiveEvenNumbers(new int[] {2, 4, 6}));
    }

    @Test
    public void testCountPositiveEvenNumbers_MixedValues() {
        Assert.assertEquals(2, LoopCoverageUtils.countPositiveEvenNumbers(new int[] {-2, 2, 5, 8, -6}));
    }
}