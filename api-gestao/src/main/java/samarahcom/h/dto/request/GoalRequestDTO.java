package samarahcom.h.dto.request;

import samarahcom.h.enums.GoalStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GoalRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Integer idUsuario;

    @NotBlank(message = "O nome da meta é obrigatorio")
    @Size(min = 3, max = 100, message = "O nome da meta deve ter entre 3 á 100 caracteres")
    private String nome;

    @NotNull(message = "O valor objetivo é obrigatório")
    @Positive(message = "O valor objetivo deve ser positivo ou maior que 0")
    private Double valorObjetivo;

    @NotNull(message = "O valor atual é obrigatório")
    @PositiveOrZero(message = "O valor atual deve ser zero ou positivo")
    private Double valorAtual;

    private GoalStatus statusMeta = GoalStatus.ATIVA;

    @FutureOrPresent(message = "A data limite deve ser hoje ou uma data futura")
    private Date dataLimite;
}
