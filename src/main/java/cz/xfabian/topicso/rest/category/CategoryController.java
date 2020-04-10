package cz.xfabian.topicso.rest.category;

import cz.xfabian.topicso.rest.category.model.CategoryModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/categories")
public interface CategoryController {

    @GetMapping
    List<CategoryModel> getMainCategories();
}
