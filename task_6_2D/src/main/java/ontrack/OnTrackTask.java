package ontrack;

import java.util.ArrayList;
import java.util.List;

public class OnTrackTask {
    private final String taskId;
    private final String studentId;
    private final String title;
    private String status;
    private final List<String> feedbackMessages;

    public OnTrackTask(String taskId, String studentId, String title) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.title = title;
        this.status = "PENDING";
        this.feedbackMessages = new ArrayList<>();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getFeedbackMessages() {
        return feedbackMessages;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFeedbackMessage(String message) {
        feedbackMessages.add(message);
    }
}
