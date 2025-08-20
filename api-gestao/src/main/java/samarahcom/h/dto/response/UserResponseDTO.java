package samarahcom.h.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserResponseDTO {
    private Integer idUsuario;
    private String nome;
    private String email;
    private Date dataCadastro;
}
