package samarahcom.h.model;

import jakarta.persistence.*;
import lombok.*;
import samarahcom.h.enums.TransactionStatus;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "lancamento")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLancamento;

    private String descricao;
    private Double valor;
    private Date dataLancamento;
    private TransactionStatus naturezaLancamento;

    @ManyToOne
    private User idUsuario;
    @ManyToOne
    private Category idCategoria;
}
