package samarahcom.h.dto.response;

import samarahcom.h.enums.GoalStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class GoalResponseDTO {

    private Integer idMeta;
    private Integer idUsuario;
    private String nome;
    private Double valorObjetivo;
    private Double valorAtual;
    private GoalStatus statusMeta;
    private Date dataLimite;
}
