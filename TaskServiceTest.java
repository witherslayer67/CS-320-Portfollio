import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;
    private Task task;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        task = new Task("T1", "Task One", "Description One");
    }

    @Test
    public void testAddTask() {
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("T1"));
    }

    @Test
    public void testAddDuplicateTask() {
        taskService.addTask(task);
        Task duplicateTask = new Task("T1", "Task Two", "Description Two");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(duplicateTask);
        });
    }

    @Test
    public void testAddNullTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });
    }

    @Test
    public void testDeleteTask() {
        taskService.addTask(task);
        taskService.deleteTask("T1");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("T1");
        });
    }

    @Test
    public void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("NonExistent");
        });
    }

    @Test
    public void testUpdateTaskName() {
        taskService.addTask(task);
        taskService.updateTaskName("T1", "Updated Name");
        assertEquals("Updated Name", taskService.getTask("T1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        taskService.addTask(task);
        taskService.updateTaskDescription("T1", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("T1").getDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("NonExistent", "New Name");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("NonExistent", "New Desc");
        });
    }
}