package seminar8.service;

import org.springframework.stereotype.Service;
import seminar8.aop.TrackUserAction;
import seminar8.model.Task;
import seminar8.repository.TaskRepository;
import seminar8.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @TrackUserAction
    @Override
    public List<Task> getTaskByStatus(Task.STATUS status){
        return taskRepository.findByStatus(status);
    }

    @TrackUserAction
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @TrackUserAction
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task.STATUS status) {
        Task existingTask = getTaskById(id);
        existingTask.setStatus(status);
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        getTaskById(id);
        taskRepository.deleteById(id);
    }


}
