package samarahcom.h.service;

import samarahcom.h.dto.request.CategoryRequestDTO;
import samarahcom.h.dto.response.CategoryResponseDTO;
import samarahcom.h.exception.NaoEncontradoException;
import samarahcom.h.mapper.CategoryMapper;
import samarahcom.h.model.Category;
import org.springframework.stereotype.Service;
import samarahcom.h.model.User;
import samarahcom.h.repository.CategoryRepository;
import samarahcom.h.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public CategoryResponseDTO criar(CategoryRequestDTO dto) {

        Category categoryModel = CategoryMapper.toEntity(dto);
        Category salvo = categoryRepository.save(categoryModel);

        return CategoryMapper.toDto(salvo);
    }

    public CategoryResponseDTO atualizar(CategoryRequestDTO dto, Integer id) {

        Category existente = categoryRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Categoria com ID " + id + " não encontrada"));

        existente.setNome(dto.getNome());
        existente.setTipoTransacao(dto.getTipoTransacao());

        Category salvo = categoryRepository.save(existente);

        return CategoryMapper.toDto(salvo);
    }

    public void deletar(Integer id) {

        boolean existe = categoryRepository.existsById(id);

        if (!categoryRepository.existsById(id)) {
            throw new NaoEncontradoException("Categoria com ID " + id + " não encontrada");
        }

        categoryRepository.deleteById(id);
    }

    public List<CategoryResponseDTO> buscarPorUsuario(Integer idUsuario) {

        boolean existe = userRepository.existsById(idUsuario);

        if (!existe) {
            throw new NaoEncontradoException("Usuário com id " + idUsuario + " não encontrado.");
        }

        List<Category> categorias = categoryRepository.findByIdUsuario_IdUsuario(idUsuario);

        return categorias.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryResponseDTO> buscarPorNome(Integer idUsuario, String nome){

        boolean existe = userRepository.existsById(idUsuario);

        if(!existe){
            throw new NaoEncontradoException("Usuário com id " + idUsuario + " não encontrado");
        }

        List<Category> categorias = categoryRepository.findByNomeContainingIgnoreCaseAndIdUsuario_IdUsuario(idUsuario, nome);

        return categorias.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO buscarPorId(Integer id){
        Category categoria = categoryRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Categoria com ID " + id + " não encontrada."));

        return CategoryMapper.toDto(categoria);
    }

}
