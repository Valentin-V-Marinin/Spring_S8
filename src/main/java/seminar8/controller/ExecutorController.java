package seminar8.controller;

import org.springframework.web.bind.annotation.*;
import seminar8.service.ExecutorService;
import seminar8.model.Executor;

import java.util.List;

@RestController
@RequestMapping("/api/exec")
public class ExecutorController {

    private final ExecutorService executorService;

    public ExecutorController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @GetMapping
    public List<Executor> getAllExecutors() {
        return executorService.getAllExecutors();
    }

    @GetMapping("/{id}")
    public Executor getExecutorById(@PathVariable Long id) {
        return executorService.getExecutorById(id);
    }

    @GetMapping("/task/{taskId}")
    public List<Executor> findTaskExecutors(@PathVariable Long taskId) {
        return executorService.findByTask(taskId);
    }

    @PostMapping
    public Executor createExecutor(@RequestBody Executor executor) {
        return executorService.createExecutor(executor);
    }

    @PutMapping("/{id}")
    public Executor updateExecutor(@PathVariable Long id, @RequestParam String name) {
        return executorService.updateExecutor(id, name);
    }

    @PutMapping("/{executorId}/task/{taskId}")
    public Executor assignTaskToExecutor(@PathVariable Long taskId, @PathVariable Long executorId) {
        return executorService.assignTask(taskId, executorId);
    }

    @DeleteMapping("/{id}")
    public void deleteExecutor(@PathVariable Long id) {
        executorService.deleteExecutor(id);
    }
}
