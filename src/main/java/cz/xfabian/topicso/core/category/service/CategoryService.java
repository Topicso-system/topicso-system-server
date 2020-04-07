package cz.xfabian.topicso.core.category.service;

import cz.xfabian.topicso.persistence.category.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getMainCategories();
}
