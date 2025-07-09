package repository;

import model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Integer> {

    List<Goal> findByIdUsuario_IdUsuario(Integer idUsuario);

    List<Goal> findByNomeContainingIgnoreCaseAndIdUsuario_IdUsuario(Integer idUsuario, String nome);

}
