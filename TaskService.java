import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (taskId == null || !taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.remove(taskId);
    }

    public void updateTaskName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    public void updateTaskDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }

    public Task getTask(String taskId) {
        if (taskId == null || !taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        return taskMap.get(taskId);
    }
}