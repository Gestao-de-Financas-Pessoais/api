package dto.request;

import enums.CategoryStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Integer idUsuario;

    @NotBlank(message = "O nome da categoria é obrigatorio")
    @Size(min = 3, max = 100, message = "O nome da categoria deve ter entre 3 á 100 caracteres")
    private String nome;

    private CategoryStatus tipoTransacao;
}
