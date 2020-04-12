package cz.xfabian.topicso.domain.difficulty;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static cz.xfabian.topicso.domain.difficulty.DifficultyLevel.*;

public class DifficultyLevelTest {

    @Test
    public void displayNameTest() {
        Assert.assertEquals("Beginner", BEGINNER.getDisplayName());
        Assert.assertEquals("Advanced", ADVANCED.getDisplayName());
        Assert.assertEquals("Intermediate", INTERMEDIATE.getDisplayName());
    }

    @Test
    public void getAllDifficultyLevelsTest() {
        Assert.assertEquals(List.of(BEGINNER, ADVANCED, INTERMEDIATE), getAllDifficultyLevels());
    }
}
