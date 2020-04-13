package cz.xfabian.topicso.rest.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModel;
import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModelMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class DifficultyLevelModelMapperTest extends AbstractEntityModelMapperTest<DifficultyLevel, DifficultyLevelModel>  {
    @Override
    protected void assertEntityModel(DifficultyLevel difficultyLevel, DifficultyLevelModel model) {
        Assertions.assertAll("CategoryEntity to CategoryModel",
                () -> Assert.assertEquals(difficultyLevel.name(), model.getID()),
                () -> Assert.assertEquals(difficultyLevel.getDisplayName(), model.getDisplayName())
        );
    }

    @Override
    protected ModelMapper<DifficultyLevelModel, DifficultyLevel> getMapper() {
        return new DifficultyLevelModelMapper();
    }

    @Override
    protected List<DifficultyLevel> getEntities() {
        return ImmutableList.of(
                DifficultyLevel.BEGINNER,
                DifficultyLevel.ADVANCED,
                DifficultyLevel.INTERMEDIATE
        );
    }
}
