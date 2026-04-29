package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    private static final double DELTA = 0.001;

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
    public void testQ1AdditionValidIntegers() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), DELTA);
    }

    @Test
    public void testQ1AdditionValidDecimals() {
        Assert.assertEquals(4.0, MathQuestionService.q1Addition("2.5", "1.5"), DELTA);
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition(null, "5")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("abc", "5")));
    }

    @Test
    public void testQ2SubtractionValidIntegers() {
        Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("5", "3"), DELTA);
    }

    @Test
    public void testQ2SubtractionValidDecimals() {
        Assert.assertEquals(1.5, MathQuestionService.q2Subtraction("4.0", "2.5"), DELTA);
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("8", "")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("eight", "2")));
    }

    @Test
    public void testQ3MultiplicationValidIntegers() {
        Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), DELTA);
    }

    @Test
    public void testQ3MultiplicationValidDecimals() {
        Assert.assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3"), DELTA);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("", "")));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("2", null)));
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("2", "xyz")));
    }
}