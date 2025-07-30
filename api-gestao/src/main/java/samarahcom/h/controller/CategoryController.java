package samarahcom.h.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samarahcom.h.dto.request.CategoryRequestDTO;
import samarahcom.h.dto.response.CategoryResponseDTO;
import samarahcom.h.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> criar(@Valid @RequestBody CategoryRequestDTO dto) {

        CategoryResponseDTO categoriaCriada = categoryService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> atualizar(@Valid @RequestBody CategoryRequestDTO dto, @PathVariable Integer id) {

        CategoryResponseDTO categoriaAtualizada = categoryService.atualizar(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> delete(@PathVariable Integer id) {

        categoryService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/minhas-categorias/{idUsuario}")
    public ResponseEntity<List<CategoryResponseDTO>> listarCategoriasPorUsuarios(@PathVariable Integer idUsuario) {

        List<CategoryResponseDTO> categorias = categoryService.buscarPorUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/minhas-categorias/{idUsuario}/nome/{nome}")
    public ResponseEntity<List<CategoryResponseDTO>> listarCategoriasPorNome(@RequestParam String nome, @PathVariable Integer idUsuario) {

        List<CategoryResponseDTO> categorias = categoryService.buscarPorNome(idUsuario, nome);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> buscarPorId(@PathVariable Integer id) {

        CategoryResponseDTO categoriaEncontrada = categoryService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaEncontrada);
    }
}
