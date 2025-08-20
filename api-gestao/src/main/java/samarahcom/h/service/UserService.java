package samarahcom.h.service;

import samarahcom.h.dto.request.UserRequestDTO;
import samarahcom.h.dto.response.UserResponseDTO;
import samarahcom.h.exception.NaoEncontradoException;
import samarahcom.h.mapper.UserMapper;
import samarahcom.h.model.User;
import samarahcom.h.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserResponseDTO criar(UserRequestDTO dto) {

        User usuarioModel = UserMapper.toEntity(dto);
        User salvo = userRepository.save(usuarioModel);

        return UserMapper.toDto(salvo);
    }

    public UserResponseDTO atualizar(Integer id, UserRequestDTO dto) {

        User existente = userRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Usuário com ID " + id + " não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setSenha(dto.getSenha());

        User salvo = userRepository.save(existente);
        return UserMapper.toDto(salvo);
    }

    public void deletar(Integer id) {

        boolean existe = userRepository.existsById(id);
        if (!existe) {
            throw new NaoEncontradoException("Usuário com id " + id + " não encontrado");
        }
        userRepository.deleteById(id);
    }

    public UserResponseDTO buscarPorEmail(String email) {

        User usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new NaoEncontradoException("Usuário com email " + email + " não encontrado"));

        return UserMapper.toDto(usuario);
    }

}
