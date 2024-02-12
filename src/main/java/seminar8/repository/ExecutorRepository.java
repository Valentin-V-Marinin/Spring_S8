package seminar8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seminar8.model.Task;
import seminar8.model.Executor;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {

    List<Executor> findByTask(Task task);

}
