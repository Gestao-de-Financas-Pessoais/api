package samarahcom.h.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import samarahcom.h.dto.request.TransactionRequestDTO;
import samarahcom.h.dto.response.TransactionResponseDTO;
import samarahcom.h.model.Category;
import samarahcom.h.model.Transaction;
import samarahcom.h.model.User;

public class TransactionMapper {
    private static final Logger logger = LoggerFactory.getLogger(TransactionMapper.class);

    public static Transaction toEntity(TransactionRequestDTO dto) {

        if (dto == null) {
            logger.warn("LaunchRequestDTO recebida é null");
            return null;
        }

        User usuario = new User();
        usuario.setIdUsuario(dto.getIdUsuario());

        Category categoria = new Category();
        categoria.setIdCategoria(dto.getIdCategoria());


        return Transaction.builder()
                .idUsuario(usuario)
                .idCategoria(categoria)
                .descricao(dto.getDescricao())
                .valor(dto.getValor())
                .dataLancamento(dto.getDataLancamento())
                .naturezaLancamento(dto.getNaturezaLancamento())
                .build();
    }

    public static TransactionResponseDTO toDto(Transaction entity) {

        if (entity == null) {
            logger.warn("Entidade recebida é null");
            return null;
        }

        return TransactionResponseDTO.builder()
                .idLancamento(entity.getIdLancamento())
                .idUsuario(entity.getIdUsuario().getIdUsuario())
                .idCategoria(entity.getIdCategoria().getIdCategoria())
                .descricao(entity.getDescricao())
                .valor(entity.getValor())
                .dataLancamento(entity.getDataLancamento())
                .naturezaLancamento(entity.getNaturezaLancamento())
                .build();
    }
}
