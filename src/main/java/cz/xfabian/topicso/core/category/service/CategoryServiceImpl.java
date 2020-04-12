package cz.xfabian.topicso.core.category.service;

import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getMainCategories() {
        return categoryRepository.getMainCategories();
    }
}
