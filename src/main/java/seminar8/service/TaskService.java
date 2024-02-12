package seminar8.service;

import seminar8.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> getTaskByStatus(Task.STATUS status);
    Task createTask(Task task);
    Task updateTask(Long id, Task.STATUS status);
    void deleteTask(Long id);
}
