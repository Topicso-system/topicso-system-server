package cz.xfabian.topicso.rest.category;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.core.category.service.CategoryService;
import cz.xfabian.topicso.persistence.category.CategoryEntity;
import cz.xfabian.topicso.rest.RestTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class CategoryControllerTest extends RestTestBase {

    @MockBean
    private CategoryService categoryService;

    @Test
    public void getMainCategoriesTest() throws Exception {
        CategoryEntity category = entityFactory.createCategory();

        Mockito.when(categoryService.getMainCategories()).thenReturn(ImmutableList.of(category));

        mockClient.perform(get("/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(category.getId())))
                .andExpect(jsonPath("$[0].name", is(category.getName())))
                .andExpect(jsonPath("$[0].picture", is(category.getPicture())))
                .andExpect(jsonPath("$[0].parent", is(category.getParent())))
                .andExpect(jsonPath("$[0].order", is(category.getOrder())));
    }
}
