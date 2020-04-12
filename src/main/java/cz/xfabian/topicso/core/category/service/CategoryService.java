package cz.xfabian.topicso.core.category.service;

import cz.xfabian.topicso.domain.category.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getMainCategories();
}
