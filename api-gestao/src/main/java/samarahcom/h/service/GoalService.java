package samarahcom.h.service;

import samarahcom.h.dto.request.GoalRequestDTO;
import samarahcom.h.dto.response.GoalResponseDTO;
import samarahcom.h.exception.NaoEncontradoException;
import samarahcom.h.mapper.GoalMapper;
import samarahcom.h.model.Goal;
import org.springframework.stereotype.Service;
import samarahcom.h.repository.GoalRepository;
import samarahcom.h.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    private final UserRepository userRepository;

    public GoalService(GoalRepository goalRepository, UserRepository userRepository) {

        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    public GoalResponseDTO criar(GoalRequestDTO dto) {

        Goal goalModel = GoalMapper.toEntity(dto);
        Goal salvo = goalRepository.save(goalModel);

        return GoalMapper.toDto(salvo);
    }

    public GoalResponseDTO atualizar(GoalRequestDTO dto, Integer id) {

        Goal existente = goalRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Meta com ID " + id + " não encontrado"));

        existente.setNome(dto.getNome());
        existente.setValorObjetivo(dto.getValorObjetivo());
        existente.setValorAtual(dto.getValorAtual());
        existente.setStatusMeta(dto.getStatusMeta());
        existente.setDataLimite(dto.getDataLimite());

        Goal salvo = goalRepository.save(existente);

        return GoalMapper.toDto(salvo);

    }

    public void deletar(Integer id) {

        boolean existe = goalRepository.existsById(id);

        if (!existe) {
            throw new NaoEncontradoException("Meta com id " + id + " não encontrada");
        }

        goalRepository.deleteById(id);
    }

    public List<GoalResponseDTO> listarMetasPorUsuario(Integer idUsuario) {

        boolean existe = userRepository.existsById(idUsuario);

        if (!existe) {
            throw new NaoEncontradoException("Usuário com id " + idUsuario + " não encontrado");
        }

        List<Goal> metas = goalRepository.findByIdUsuario_IdUsuario(idUsuario);

        return metas.stream()
                .map(GoalMapper::toDto)
                .collect(Collectors.toList());
    }

    public GoalResponseDTO buscarPorId(Integer id) {
        Goal meta = goalRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Meta com ID " + id + " não encontrado"));

        return GoalMapper.toDto(meta);
    }

    public List<GoalResponseDTO> buscarPorNome(Integer idUsuario, String nome){

        List<Goal> metas = goalRepository.findByNomeContainingIgnoreCaseAndIdUsuario_IdUsuario(idUsuario, nome);

        return metas.stream()
                .map(GoalMapper::toDto)
                .collect(Collectors.toList());
    }
}
