package service;

import dto.request.CategoryRequestDTO;
import dto.response.CategoryResponseDTO;
import mapper.CategoryMapper;
import model.Category;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDTO criar(CategoryRequestDTO dto) {

        Category categoryModel = CategoryMapper.toEntity(dto);
        Category salvo = categoryRepository.save(categoryModel);

        return CategoryMapper.toDto(salvo);
    }


}
