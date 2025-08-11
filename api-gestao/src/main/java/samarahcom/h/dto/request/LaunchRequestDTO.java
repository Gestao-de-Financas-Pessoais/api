package samarahcom.h.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import samarahcom.h.enums.LaunchStatus;

import java.util.Date;


@Getter
@Setter
public class LaunchRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Integer idUsuario;

    @NotNull(message = "O ID da categoria é obrigatório")
    private Integer idCategoria;

    @Size(max = 120, message = "A descrição deve ter no máximo 120 caracteres")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private Double valor;

    @NotNull(message = "A data do lançamento é obrigatória")
    private Date dataLancamento;

    @NotNull(message = "A natureza do lançamento é obrigatória")
    private LaunchStatus naturezaLancamento;
}
