package cz.xfabian.topicso.persistence;

import cz.xfabian.topicso.persistence.category.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class TestEntityFactory {

    public CategoryEntity createCategory() {
        return createCategory("TestCategory", null);
    }

    public CategoryEntity createCategory(String categoryName) {
        return createCategory(categoryName, null);
    }

    public CategoryEntity createCategory(String categoryName, CategoryEntity parent) {
        CategoryEntity category = new CategoryEntity();
        category.setName(categoryName);
        category.setPicture("picture");
        category.setOrder(1);
        category.setParent(parent);
        return category;
    }
}
