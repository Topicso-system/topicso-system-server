package cz.xfabian.topicso.rest.difficulty.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;

import java.util.List;

public class DifficultyLevelModelMapper {

    public List<DifficultyLevelModel> map(List<DifficultyLevel> difficultyLevels) {
        ImmutableList.Builder<DifficultyLevelModel> difficultyLevelsModelBuilder = ImmutableList.builder();

        for (DifficultyLevel difficultyLevel: difficultyLevels) {
            difficultyLevelsModelBuilder.add(map(difficultyLevel));
        }

        return difficultyLevelsModelBuilder.build();
    }

    public DifficultyLevelModel map(DifficultyLevel difficultyLevel) {
        return new DifficultyLevelModel(difficultyLevel.name(), difficultyLevel.getDisplayName());
    }
}
