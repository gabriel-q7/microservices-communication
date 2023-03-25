package br.com.commicros.productapi.modules.category.service;

import br.com.commicros.productapi.config.exception.ValidationException;
import br.com.commicros.productapi.modules.category.dto.CategoryRequest;
import br.com.commicros.productapi.modules.category.dto.CategoryResponse;
import br.com.commicros.productapi.modules.category.model.Category;
import br.com.commicros.productapi.modules.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no category for the given ID."));
    }

    public CategoryResponse save(CategoryRequest request) {
        validateCategoryNameInformed(request);
        var category = categoryRepository.save(Category.of(request));
        return CategoryResponse.of(category);
    }

    public void validateCategoryNameInformed(CategoryRequest request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed");
        }
    }
}