package samarahcom.h.service;


import samarahcom.h.dto.request.TransactionRequestDTO;
import samarahcom.h.dto.response.TransactionResponseDTO;
import samarahcom.h.exception.NaoEncontradoException;
import samarahcom.h.mapper.TransactionMapper;
import samarahcom.h.model.Transaction;
import samarahcom.h.repository.TransactionRepository;
import samarahcom.h.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    private final TransactionRepository launchRepository;
    private final UserRepository userRepository;

    public TransactionService(
            TransactionRepository launchRepository,
            UserRepository userRepository
    ) {
        this.launchRepository = launchRepository;
        this.userRepository = userRepository;
    }

    public TransactionResponseDTO criar(TransactionRequestDTO dto) {

        Transaction launch = TransactionMapper.toEntity(dto);
        Transaction salvo = launchRepository.save(launch);

        return TransactionMapper.toDto(salvo);
    }

    public TransactionResponseDTO atualizar(TransactionRequestDTO dto, Integer id) {

        Transaction existente = launchRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Lançamento com ID " + id + " não encontrado"));

        existente.setDescricao(dto.getDescricao());
        existente.setValor(dto.getValor());
        existente.setDataLancamento(dto.getDataLancamento());
        existente.setNaturezaLancamento(dto.getNaturezaLancamento());

        Transaction salvo = launchRepository.save(existente);

        return TransactionMapper.toDto(salvo);
    }

    public void deletar(Integer id) {

        boolean existe = launchRepository.existsById(id);

        if (!existe) {
            throw new NaoEncontradoException("Lançamento com ID " + id + " não encontrado");
        }

        launchRepository.deleteById(id);

    }

    public List<TransactionResponseDTO> listarPorUsuario(Integer idUsuario){

        boolean existe = userRepository.existsById(idUsuario);

        if (!existe) {
            throw new NaoEncontradoException("Usuário com id " + idUsuario + " não encontrado.");
        }

        List<Transaction> lancamentos = launchRepository.findByIdUsuario_IdUsuario(idUsuario);

        return lancamentos.stream()
                .map(TransactionMapper::toDto)
                .collect(Collectors.toList());
    }

    /*

    Adicionar funcianalidades depois como :

    trnsações das ultimas 24 horas
    ultimos 7 dias
    ultimos 15 dias
    ultimos 30 dias
    periods de X á Y

    */

}