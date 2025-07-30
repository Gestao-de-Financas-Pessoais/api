package samarahcom.h.controller;

import samarahcom.h.dto.request.GoalRequestDTO;
import samarahcom.h.dto.response.GoalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samarahcom.h.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public ResponseEntity<GoalResponseDTO> criar(@Valid @RequestBody GoalRequestDTO dto) {

        GoalResponseDTO metaCriada = goalService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalResponseDTO> atualizar(@Valid @RequestBody GoalRequestDTO dto, @PathVariable Integer id) {

        GoalResponseDTO metaAtualizada = goalService.atualizar(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(metaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        goalService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/minhas-metas/{idUsuario}")
    public ResponseEntity<List<GoalResponseDTO>> listarMetasPorUsuario(@PathVariable Integer idUsuario) {

        List<GoalResponseDTO> metas = goalService.listarMetasPorUsuario(idUsuario);
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/minhas-metas/{idUsuario}/nome/{nome}")
    public ResponseEntity<List<GoalResponseDTO>> listarMetasPorNome(@PathVariable Integer idUsuario, @RequestParam String nome){

        List<GoalResponseDTO> metas = goalService.buscarPorNome(idUsuario, nome);
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponseDTO> buscarPorId(@PathVariable Integer id){

        GoalResponseDTO metaEncontrada = goalService.buscarPorId(id);
        return ResponseEntity.ok(metaEncontrada);
    }

}
