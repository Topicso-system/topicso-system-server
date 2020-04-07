package cz.xfabian.topicso.persistence.category;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveTest() {
        CategoryEntity origin = createCategory();

        CategoryEntity savedCategory = categoryRepository.save(origin);

        CategoryEntity loadedCategory = categoryRepository.findById(savedCategory.getId()).get();
        Assertions.assertAll("Category",
                () -> Assertions.assertEquals(origin.getName(), loadedCategory.getName(), "Category name  is not correct"),
                () -> Assertions.assertEquals(origin.getParent(), loadedCategory.getParent(), "Category parent is not correct"),
                () -> Assertions.assertEquals(origin.getPicture(), loadedCategory.getPicture(), "Category picture is not correct"),
                () -> Assertions.assertEquals(origin.getOrder(), loadedCategory.getOrder(), "Category order is not correct")
        );
    }

    private CategoryEntity createCategory() {
        CategoryEntity category = new CategoryEntity();
        category.setName("TestCategory");
        category.setPicture("picture");
        category.setOrder(1);
        return category;
    }
}
