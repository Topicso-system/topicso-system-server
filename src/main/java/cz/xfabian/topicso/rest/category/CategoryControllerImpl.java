package cz.xfabian.topicso.rest.category;

import cz.xfabian.topicso.core.category.service.CategoryService;
import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.rest.category.model.CategoryEntityModelMapper;
import cz.xfabian.topicso.rest.category.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getMainCategories() {
        List<CategoryEntity> mainCategories = categoryService.getMainCategories();
        return new CategoryEntityModelMapper().map(mainCategories);
    }
}
