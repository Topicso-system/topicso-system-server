package cz.xfabian.topicso.rest.category.model;

import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.rest.model.AbstractModelMapper;

public class CategoryEntityModelMapper extends AbstractModelMapper<CategoryModel, CategoryEntity> {

    @Override
    public CategoryModel map(CategoryEntity categoryEntity) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryEntity.getId());
        categoryModel.setName(categoryEntity.getName());
        categoryModel.setOrder(categoryEntity.getOrder());
        if (categoryEntity.getParent() != null)
            categoryModel.setParent(categoryEntity.getParent().getId());
        categoryModel.setPicture(categoryEntity.getPicture());
        return categoryModel;
    }
}
