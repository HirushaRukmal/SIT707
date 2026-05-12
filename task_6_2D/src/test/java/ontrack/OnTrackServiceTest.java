package ontrack;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OnTrackServiceTest {

    private OnTrackService service;

    @Before
    public void setUp() {
        service = new OnTrackService();
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
    public void testCreateTaskReturnsCorrectTask() {
        OnTrackTask task = service.createTask("T001", "S001", "Task 1");
        Assert.assertEquals("T001", task.getTaskId());
        Assert.assertEquals("S001", task.getStudentId());
        Assert.assertEquals("Task 1", task.getTitle());
        Assert.assertEquals("PENDING", task.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithEmptyTaskId() {
        service.createTask("", "S001", "Task 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithNullStudentId() {
        service.createTask("T002", null, "Task 2");
    }

    @Test
    public void testCreateThenRetrieveTask() {
        service.createTask("T003", "S002", "Task 3");
        OnTrackTask task = service.getTaskById("T003");
        Assert.assertNotNull(task);
        Assert.assertEquals("T003", task.getTaskId());
    }

    @Test
    public void testTaskAppearsInStudentTaskList() {
        service.createTask("T004", "S003", "Task 4");
        service.createTask("T005", "S003", "Task 5");

        List<OnTrackTask> tasks = service.getTasksByStudentId("S003");
        Assert.assertEquals(2, tasks.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicateTaskIdThrowsException() {
        service.createTask("T006", "S004", "Task 6");
        service.createTask("T006", "S004", "Task 6 duplicate");
    }

    @Test
    public void testGetTaskByInvalidIdReturnsNull() {
        Assert.assertNull(service.getTaskById("INVALID"));
    }

    @Test
    public void testUpdateTaskStatusInvalidValue() {
        service.createTask("T007", "S005", "Task 7");
        Assert.assertFalse(service.updateTaskStatus("T007", "DONE"));
    }

    @Test
    public void testAddFeedbackMessageToMissingTask() {
        Assert.assertFalse(service.addFeedbackMessage("MISSING", "Feedback"));
    }

    @Test
    public void testUpdateStatusThenRetrieveTask() {
        service.createTask("T008", "S006", "Task 8");
        service.updateTaskStatus("T008", "COMPLETE");
        OnTrackTask task = service.getTaskById("T008");
        Assert.assertEquals("COMPLETE", task.getStatus());
    }

    @Test
    public void testAddFeedbackMessage() {
        service.createTask("T009", "S007", "Task 9");
        Assert.assertTrue(service.addFeedbackMessage("T009", "Please revise section 2."));
        OnTrackTask task = service.getTaskById("T009");
        Assert.assertEquals(1, task.getFeedbackMessages().size());
    }

    @Test
    public void testMultipleTaskInsertionsAndListing() {
        for (int i = 1; i <= 20; i++) {
            service.createTask("TX" + i, "S100", "Task " + i);
        }
        List<OnTrackTask> tasks = service.getTasksByStudentId("S100");
        Assert.assertEquals(20, tasks.size());
    }
}
