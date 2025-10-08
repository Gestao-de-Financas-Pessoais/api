package samarahcom.h.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import samarahcom.h.enums.TransactionStatus;

import java.util.Date;

@Getter
@Setter
@Builder
public class TransactionResponseDTO {

    private Integer idLancamento;
    private Integer idUsuario;
    private Integer idCategoria;

    private String descricao;
    private Double valor;
    private Date dataLancamento;
    private TransactionStatus naturezaLancamento;

}
