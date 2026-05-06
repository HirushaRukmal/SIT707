package ontrack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskStatusServiceTest {

    private TaskStatusService service;

    @Before
    public void setUp() {
        service = new TaskStatusService();
    }

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
    public void testPendingStatus() {
        Assert.assertEquals("Task is pending review.",
                service.getTaskStatusMessage("PENDING"));
    }

    @Test
    public void testDiscussionStatus() {
        Assert.assertEquals("Task requires discussion with tutor.",
                service.getTaskStatusMessage("DISCUSSION"));
    }

    @Test
    public void testCompleteStatus() {
        Assert.assertEquals("Task is complete.",
                service.getTaskStatusMessage("COMPLETE"));
    }

    @Test
    public void testResubmitStatus() {
        Assert.assertEquals("Task requires resubmission.",
                service.getTaskStatusMessage("RESUBMIT"));
    }

    @Test
    public void testLowerCaseInput() {
    	Assert.assertEquals("Wrong message",
    	        service.getTaskStatusMessage("PENDING"));
    }

    @Test
    public void testNullInput() {
        Assert.assertEquals("Invalid task status.",
                service.getTaskStatusMessage(null));
    }

    @Test
    public void testEmptyInput() {
        Assert.assertEquals("Invalid task status.",
                service.getTaskStatusMessage(""));
    }

    @Test
    public void testBlankInput() {
        Assert.assertEquals("Invalid task status.",
                service.getTaskStatusMessage("   "));
    }

    @Test
    public void testUnknownStatus() {
        Assert.assertEquals("Invalid task status.",
                service.getTaskStatusMessage("SUBMITTED"));
    }
}
