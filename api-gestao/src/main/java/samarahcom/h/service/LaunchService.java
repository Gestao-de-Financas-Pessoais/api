package samarahcom.h.service;


import samarahcom.h.dto.request.LaunchRequestDTO;
import samarahcom.h.dto.response.LaunchResponseDTO;
import samarahcom.h.exception.NaoEncontradoException;
import samarahcom.h.mapper.LaunchMapper;
import samarahcom.h.model.Launch;
import samarahcom.h.repository.CategoryRepository;
import samarahcom.h.repository.LaunchRepository;
import samarahcom.h.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LaunchService {

    private final LaunchRepository launchRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public LaunchService(
            LaunchRepository launchRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository
    ) {
        this.launchRepository = launchRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public LaunchResponseDTO criar(LaunchRequestDTO dto) {

        Launch launch = LaunchMapper.toEntity(dto);
        Launch salvo = launchRepository.save(launch);

        return LaunchMapper.toDto(salvo);
    }

    public LaunchResponseDTO atualizar(LaunchRequestDTO dto, Integer id) {

        Launch existente = launchRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Lançamento com ID " + id + " não encontrado"));

        existente.setDescricao(dto.getDescricao());
        existente.setValor(dto.getValor());
        existente.setDataLancamento(dto.getDataLancamento());
        existente.setNaturezaLancamento(dto.getNaturezaLancamento());

        Launch salvo = launchRepository.save(existente);

        return LaunchMapper.toDto(salvo);
    }

    public void deletar(Integer id) {

        boolean existe = launchRepository.existsById(id);

        if (!existe) {
            throw new NaoEncontradoException("Lançamento com ID " + id + " não encontrado");
        }

        launchRepository.deleteById(id);

    }

    public List<LaunchResponseDTO> listarPorusuario(Integer idUsuario){

        boolean existe = userRepository.existsById(idUsuario);

        if (!existe) {
            throw new NaoEncontradoException("Usuário com id " + idUsuario + " não encontrado.");
        }

        List<Launch> lancamentos = launchRepository.findByIdUsuario_IdUsuario(idUsuario);

        return lancamentos.stream()
                .map(LaunchMapper::toDto)
                .collect(Collectors.toList());
    }

}
