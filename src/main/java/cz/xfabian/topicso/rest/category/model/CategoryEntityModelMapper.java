package cz.xfabian.topicso.rest.category.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.persistence.category.CategoryEntity;

import java.util.List;

public class CategoryEntityModelMapper {

    public List<CategoryModel> map(List<CategoryEntity> categoryEntities) {
        ImmutableList.Builder<CategoryModel> categoryModelListBuilder = ImmutableList.builder();

        for (CategoryEntity categoryEntity: categoryEntities) {
            categoryModelListBuilder.add(map(categoryEntity));
        }

        return categoryModelListBuilder.build();
    }

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
