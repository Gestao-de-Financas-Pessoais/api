package samarahcom.h.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import samarahcom.h.enums.LaunchStatus;

import java.util.Date;

@Getter
@Setter
@Builder
public class LaunchResponseDTO {

    private Integer idLancamento;
    private Integer idUsuario;
    private Integer idCategoria;

    private String descricao;
    private Double valor;
    private Date dataLancamento;
    private LaunchStatus naturezaLancamento;

}
