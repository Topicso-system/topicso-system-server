package cz.xfabian.topicso.domain.category;

import cz.xfabian.topicso.domain.PersistenceTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class CategoryRepositoryTest extends PersistenceTestBase {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveTest() {
        CategoryEntity savedCategory = persistedEntityFactory.persistedCategory();

        CategoryEntity loadedCategory = categoryRepository.findById(savedCategory.getId()).get();

        Assertions.assertAll("Category",
                () -> Assertions.assertEquals(savedCategory.getName(), loadedCategory.getName(), "Category name  is not correct"),
                () -> Assertions.assertEquals(savedCategory.getParent(), loadedCategory.getParent(), "Category parent is not correct"),
                () -> Assertions.assertEquals(savedCategory.getPicture(), loadedCategory.getPicture(), "Category picture is not correct"),
                () -> Assertions.assertEquals(savedCategory.getOrder(), loadedCategory.getOrder(), "Category order is not correct")
        );
    }

    @Test
    public void getMainCategoriesTest() {
        CategoryEntity mainCategory1 = persistedEntityFactory.persistedCategory("MainCategory1");
        CategoryEntity mainCategory2 = persistedEntityFactory.persistedCategory("MainCategory2");
        CategoryEntity subCategory = persistedEntityFactory.persistedCategory("SubCategory", mainCategory1);

        ArrayList<CategoryEntity> mainCategories = categoryRepository.getMainCategories();

        Assert.assertEquals(List.of(mainCategory1, mainCategory2), mainCategories);
    }
}
