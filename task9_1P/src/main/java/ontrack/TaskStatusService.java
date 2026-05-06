package ontrack;

public class TaskStatusService {

    public String getTaskStatusMessage(String status) {
        if (status == null || status.trim().isEmpty()) {
            return "Invalid task status.";
        }

        switch (status.trim().toUpperCase()) {
            case "PENDING":
                return "Task is pending review.";
            case "DISCUSSION":
                return "Task requires discussion with tutor.";
            case "COMPLETE":
                return "Task is complete.";
            case "RESUBMIT":
                return "Task requires resubmission.";
            default:
                return "Invalid task status.";
        }
    }
}
