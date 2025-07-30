package samarahcom.h.repository;

import samarahcom.h.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByIdUsuario_IdUsuario(Integer idUsuario);

    List<Category> findByNomeContainingIgnoreCaseAndIdUsuario_IdUsuario(Integer idUsuario, String nome);


}
