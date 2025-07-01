package service;

import dto.request.UserRequestDTO;
import dto.response.UserResponseDTO;
import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO criarUser(UserRequestDTO dto) {

        User usuarioModel = UserMapper.toEntity(dto);
        User salvo = userRepository.save(usuarioModel);

        return UserMapper.toDto(salvo);
    }

    public UserResponseDTO buscarPorEmail(UserRequestDTO dto){

        User usuario = UserMapper.toEntity(dto);
        String usuarioEmail = usuario.getEmail();

        if(userRepository.existsByEmail(usuarioEmail)){

            User usuarioEncontrado = userRepository.
            return UserMapper.toDto(usuarioEmail);
        }

        new RuntimeException("E-mail não encontrado"));

    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
}
