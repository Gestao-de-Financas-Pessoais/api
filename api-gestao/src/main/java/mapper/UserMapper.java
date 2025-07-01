package mapper;

import dto.request.UserRequestDTO;
import dto.response.UserResponseDTO;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class UserMapper {

    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public static User toEntity(UserRequestDTO dto) {

        if (dto == null) {
            logger.warn("UserRequestDto recebida é null");
            return null;
        }
        return User.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .dataCadastro(new Date())
                .build();
    }

    public static UserResponseDTO toDto(User entity) {

        if (entity == null) {
            logger.warn("Entidade recebida é null");
            return null;
        }
        return UserResponseDTO.builder()
                .idUsuario(entity.getIdUsuario())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .dataCadastro(entity.getDataCadastro())
                .build();
    }
}
