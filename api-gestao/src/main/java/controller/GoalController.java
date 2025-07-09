package controller;

import dto.request.GoalRequestDTO;
import dto.response.GoalResponseDTO;
import jakarta.validation.Valid;
import model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.GoalService;

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
        return ResponseEntity.ok(metaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        goalService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/metas/{idUsuario}")
    public ResponseEntity<List<GoalResponseDTO>> listarMetasPorUsuario(@PathVariable Integer idUsuario) {

        List<GoalResponseDTO> metas = goalService.listarMetasPorUsuario(idUsuario);
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/metas/{idUsuario}/nome/{nome}")
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
