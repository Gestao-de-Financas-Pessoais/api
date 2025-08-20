package samarahcom.h.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 90, message = "O nome deve ter entre 3 e 90 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    @Size(max = 100, message = "O email não pode exceder 100 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;
}