package cz.xfabian.topicso.rest.difficulty;

import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.rest.RestTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
public class DifficultyLevelControllerTest extends RestTestBase {

    @Test
    public void getAllDifficultyLevels() throws Exception {
        mockClient.perform(get("/difficulties")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(DifficultyLevel.BEGINNER.name())))
                .andExpect(jsonPath("$[0].displayName", is(DifficultyLevel.BEGINNER.getDisplayName())))
                .andExpect(jsonPath("$[1].id", is(DifficultyLevel.ADVANCED.name())))
                .andExpect(jsonPath("$[1].displayName", is(DifficultyLevel.ADVANCED.getDisplayName())))
                .andExpect(jsonPath("$[2].id", is(DifficultyLevel.INTERMEDIATE.name())))
                .andExpect(jsonPath("$[2].displayName", is(DifficultyLevel.INTERMEDIATE.getDisplayName())));
    }
}
