package seminar8.service;

import seminar8.model.Executor;

import java.util.List;

public interface ExecutorService {

    List<Executor> findByTask(Long taskId);
    List<Executor> getAllExecutors();
    Executor getExecutorById(Long id);
    Executor createExecutor(Executor executor);
    Executor updateExecutor(Long id, String name);
    Executor assignTask(Long taskId, Long executorId);
    void deleteExecutor(Long id);

}
