package cz.xfabian.topicso.persistence.category;

import cz.xfabian.topicso.TopicsoTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest extends TopicsoTestBase {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveTest() {
        CategoryEntity origin = entityFactory.createCategory();

        CategoryEntity savedCategory = categoryRepository.save(origin);

        CategoryEntity loadedCategory = categoryRepository.findById(savedCategory.getId()).get();
        Assertions.assertAll("Category",
                () -> Assertions.assertEquals(origin.getName(), loadedCategory.getName(), "Category name  is not correct"),
                () -> Assertions.assertEquals(origin.getParent(), loadedCategory.getParent(), "Category parent is not correct"),
                () -> Assertions.assertEquals(origin.getPicture(), loadedCategory.getPicture(), "Category picture is not correct"),
                () -> Assertions.assertEquals(origin.getOrder(), loadedCategory.getOrder(), "Category order is not correct")
        );
    }

    @Test
    public void getMainCategoriesTest() {
        CategoryEntity mainCategory1 = entityFactory.createCategory("MainCategory1");
        CategoryEntity mainCategory2 = entityFactory.createCategory("MainCategory2");
        CategoryEntity subCategory = entityFactory.createCategory("SubCategory", mainCategory1);

        categoryRepository.save(mainCategory1);
        categoryRepository.save(mainCategory2);
        categoryRepository.save(subCategory);

        ArrayList<CategoryEntity> mainCategories = categoryRepository.getMainCategories();

        Assert.assertEquals(List.of(mainCategory1, mainCategory2), mainCategories);
    }


}
