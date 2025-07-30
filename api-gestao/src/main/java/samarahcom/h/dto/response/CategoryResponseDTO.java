package samarahcom.h.dto.response;

import samarahcom.h.enums.CategoryStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryResponseDTO {

    private Integer idCategoria;
    private Integer idUsuario;
    private String nome;
    private CategoryStatus tipoTransacao;
}
