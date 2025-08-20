package samarahcom.h.controller;

import samarahcom.h.dto.request.UserRequestDTO;
import samarahcom.h.dto.response.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samarahcom.h.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> criar(@Valid @RequestBody UserRequestDTO dto) {

        UserResponseDTO usuarioCriado = userService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid UserRequestDTO dto) {

        UserResponseDTO usuarioAtualizado = userService.atualizar(id, dto);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> buscarPorEmail(@RequestParam String email){

        UserResponseDTO usuario = userService.buscarPorEmail(email);
        return ResponseEntity.ok(usuario);
    }
}
