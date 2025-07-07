package service;

import dto.request.UserRequestDTO;
import dto.response.UserResponseDTO;
import exception.UsuarioNaoEncontradoException;
import mapper.UserMapper;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com ID " + id + " não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setSenha(dto.getSenha());

        User salvo = userRepository.save(existente);
        return UserMapper.toDto(salvo);
    }

    public void deletar(Integer id) {

        boolean existe = userRepository.existsById(id);
        if (!existe) {
            throw new UsuarioNaoEncontradoException("Usuário com id " + id + "não encontrado");
        }
        userRepository.deleteById(id);
    }

    public Optional<UserResponseDTO> buscarPorEmail(String email) {

        return userRepository.findByEmail(email)
                .map(UserMapper::toDto);
    }

}
