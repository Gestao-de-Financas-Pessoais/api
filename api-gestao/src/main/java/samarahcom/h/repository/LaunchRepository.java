package samarahcom.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samarahcom.h.model.Category;
import samarahcom.h.model.Launch;

import java.util.List;

public interface LaunchRepository extends JpaRepository <Launch, Integer> {

    List<Launch> findByIdUsuario_IdUsuario(Integer idUsuario);

}
