import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("12345", "Test Name", "Test Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Name", task.getName());
        assertEquals("Test Description", task.getDescription());
    }

    @Test
    public void testTaskNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Name", "Test Description");
        });
    }

    @Test
    public void testTaskTooLongId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Name", "Test Description");
        });
    }

    @Test
    public void testTaskNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Test Description");
        });
    }

    @Test
    public void testTaskTooLongName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "123456789012345678901", "Test Description");
        });
    }

    @Test
    public void testTaskNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Name", null);
        });
    }

    @Test
    public void testTaskTooLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Name", "123456789012345678901234567890123456789012345678901");
        });
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("12345", "Test Name", "Test Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testUpdateTaskNameInvalid() {
        Task task = new Task("12345", "Test Name", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("123456789012345678901");
        });
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("12345", "Test Name", "Test Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testUpdateTaskDescriptionInvalid() {
        Task task = new Task("12345", "Test Name", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("123456789012345678901234567890123456789012345678901");
        });
    }
}