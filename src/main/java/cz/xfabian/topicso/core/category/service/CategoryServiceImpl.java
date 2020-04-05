package cz.xfabian.topicso.core.category.service;

import cz.xfabian.topicso.core.category.data.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getMainCategories() {
        return null;
    }

    @Override
    public List<Category> getSubCategories(int parentCategoryId) {
        return null;
    }
}
