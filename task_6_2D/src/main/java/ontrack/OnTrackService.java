package ontrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnTrackService {

    private final Map<String, OnTrackTask> tasks = new HashMap<>();

    public OnTrackTask createTask(String taskId, String studentId, String title) {
        if (taskId == null || studentId == null || title == null) {
            throw new IllegalArgumentException("Task fields cannot be null.");
        }
        if (taskId.trim().isEmpty() || studentId.trim().isEmpty() || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task fields cannot be empty.");
        }
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists.");
        }

        OnTrackTask task = new OnTrackTask(taskId, studentId, title);
        tasks.put(taskId, task);
        return task;
    }

    public OnTrackTask getTaskById(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            return null;
        }
        return tasks.get(taskId);
    }

    public List<OnTrackTask> getTasksByStudentId(String studentId) {
        List<OnTrackTask> result = new ArrayList<>();

        if (studentId == null || studentId.trim().isEmpty()) {
            return result;
        }

        for (OnTrackTask task : tasks.values()) {
            if (task.getStudentId().equals(studentId)) {
                result.add(task);
            }
        }
        return result;
    }

    public boolean updateTaskStatus(String taskId, String newStatus) {
        OnTrackTask task = tasks.get(taskId);

        if (task == null || newStatus == null || newStatus.trim().isEmpty()) {
            return false;
        }

        if (!newStatus.equals("PENDING")
                && !newStatus.equals("UNDER_REVIEW")
                && !newStatus.equals("COMPLETE")
                && !newStatus.equals("RESUBMIT")) {
            return false;
        }

        task.setStatus(newStatus);
        return true;
    }

    public boolean addFeedbackMessage(String taskId, String message) {
        OnTrackTask task = tasks.get(taskId);

        if (task == null || message == null || message.trim().isEmpty()) {
            return false;
        }

        task.addFeedbackMessage(message);
        return true;
    }
}
