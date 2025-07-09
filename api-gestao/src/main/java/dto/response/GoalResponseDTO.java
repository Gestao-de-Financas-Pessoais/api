package dto.response;

import enums.StatusGoal;
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
    private StatusGoal statusMeta;
    private Date dataLimite;
}
