package cz.xfabian.topicso.core.category.service;

import cz.xfabian.topicso.core.category.data.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getMainCategories();

    List<Category> getSubCategories(int parentCategoryId);
}
