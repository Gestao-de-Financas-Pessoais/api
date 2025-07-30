package samarahcom.h.mapper;

import samarahcom.h.dto.request.CategoryRequestDTO;
import samarahcom.h.dto.response.CategoryResponseDTO;
import samarahcom.h.model.Category;
import samarahcom.h.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryMapper {

    private static final Logger logger = LoggerFactory.getLogger(CategoryMapper.class);

    public static Category toEntity(CategoryRequestDTO dto) {

        if (dto == null) {
            logger.warn("CategoryRequestDTO recebida é null");
            return null;
        }

        User usuario = new User();
        usuario.setIdUsuario(dto.getIdUsuario());


        return Category.builder()
                .idUsuario(usuario)
                .nome(dto.getNome())
                .tipoTransacao(dto.getTipoTransacao())
                .build();
    }

    public static CategoryResponseDTO toDto(Category entity){

        if (entity == null){
            logger.warn("Entidade recebida é null");
            return null;
        }

        return CategoryResponseDTO.builder()
                .idUsuario(entity.getIdUsuario().getIdUsuario())
                .nome(entity.getNome())
                .tipoTransacao(entity.getTipoTransacao())
                .build();
    }
}
