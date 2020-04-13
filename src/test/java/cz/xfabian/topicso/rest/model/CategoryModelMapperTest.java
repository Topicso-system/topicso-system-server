package cz.xfabian.topicso.rest.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.rest.category.model.CategoryEntityModelMapper;
import cz.xfabian.topicso.rest.category.model.CategoryModel;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class CategoryModelMapperTest extends AbstractEntityModelMapperTest<CategoryEntity, CategoryModel> {

    @Override
    protected void assertEntityModel(CategoryEntity categoryEntity, CategoryModel categoryModel) {
        Assertions.assertAll("CategoryEntity to CategoryModel",
                () -> Assert.assertEquals(categoryEntity.getId(), categoryModel.getId()),
                () -> Assert.assertEquals(categoryEntity.getName(), categoryModel.getName()),
                () -> {
                        if (categoryEntity.getParent() != null)
                            Assert.assertEquals(categoryEntity.getParent().getId(), categoryModel.getParent());
                },
                () -> Assert.assertEquals(categoryEntity.getOrder(), categoryModel.getOrder()),
                () -> Assert.assertEquals(categoryEntity.getPicture(), categoryModel.getPicture())
        );
    }

    @Override
    protected ModelMapper<CategoryModel, CategoryEntity> getMapper() {
        return new CategoryEntityModelMapper();
    }

    @Override
    protected List<CategoryEntity> getEntities() {
        CategoryEntity category1 = entityFactory.createCategory("Category1");
        CategoryEntity category2 = entityFactory.createCategory("Category2", category1);
        return ImmutableList.of(category1, category2);
    }
}
