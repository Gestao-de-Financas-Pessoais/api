package mapper;

import dto.request.GoalRequestDTO;
import dto.response.GoalResponseDTO;
import model.Goal;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoalMapper {

    private static final Logger logger = LoggerFactory.getLogger(GoalMapper.class);

    public static Goal toEntity(GoalRequestDTO dto) {

        User usuario = new User();
        usuario.setIdUsuario(dto.getIdUsuario());

        if (dto == null) {
            logger.warn("GoalRequestDto recebida é null");
            return null;
        }

        return Goal.builder()
                .idUsuario(usuario)
                .nome(dto.getNome())
                .valorObjetivo(dto.getValorObjetivo())
                .valorAtual(dto.getValorAtual())
                .statusMeta(dto.getStatusMeta())
                .dataLimite(dto.getDataLimite())
                .build();
    }

    public static GoalResponseDTO toDto(Goal entity) {

        if (entity == null) {
            logger.warn("Entidade recebida é null");
            return null;
        }

        return GoalResponseDTO.builder()
                .idMeta(entity.getIdMeta())
                .idUsuario(entity.getIdUsuario().getIdUsuario())
                .nome(entity.getNome())
                .valorObjetivo(entity.getValorObjetivo())
                .valorAtual(entity.getValorAtual())
                .statusMeta(entity.getStatusMeta())
                .dataLimite(entity.getDataLimite())
                .build();
    }

}
