package seminar8.service;

import org.springframework.stereotype.Service;
import seminar8.aop.TrackUserAction;
import seminar8.model.Task;
import seminar8.model.Executor;
import seminar8.repository.ExecutorRepository;

import java.util.List;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorRepository executorRepository;
    public  final TaskService taskService;

    public ExecutorServiceImpl(ExecutorRepository executorRepository, TaskService taskService) {
        this.executorRepository = executorRepository;
        this.taskService = taskService;
    }

    public List<Executor> findByTask(Long taskId){
        Task task = taskService.getTaskById(taskId);
        return executorRepository.findByTask(task);
    }

    @TrackUserAction
    @Override
    public List<Executor> getAllExecutors() {
        return executorRepository.findAll();
    }

    @TrackUserAction
    @Override
    public Executor getExecutorById(Long id) {
        return executorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Executor not found"));
    }

    @TrackUserAction
    @Override
    public Executor createExecutor(Executor executor) {
        return executorRepository.save(executor);
    }

    @Override
    public Executor updateExecutor(Long id, String name) {
        Executor executor = getExecutorById(id);
        executor.setName(name);
        return executorRepository.save(executor);
    }

    @TrackUserAction
    public Executor assignTask(Long taskId, Long executorId) {
        Task task = taskService.getTaskById(taskId);
        Executor executor = getExecutorById(executorId);
        executor.setTask(task);
        return executorRepository.save(executor);
    }

    @Override
    public void deleteExecutor(Long id) {
        getExecutorById(id);
        executorRepository.deleteById(id);
    }
}
