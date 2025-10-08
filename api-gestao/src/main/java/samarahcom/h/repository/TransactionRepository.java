package samarahcom.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samarahcom.h.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository <Transaction, Integer> {

    List<Transaction> findByIdUsuario_IdUsuario(Integer idUsuario);

}
