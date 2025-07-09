package dto.response;

import enums.CategoryStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.User;

@Getter
@Setter
@Builder
public class CategoryResponseDTO {

    private Integer idCategoria;
    private Integer idUsuario;
    private String nome;
    private CategoryStatus tipoTransacao;
}
