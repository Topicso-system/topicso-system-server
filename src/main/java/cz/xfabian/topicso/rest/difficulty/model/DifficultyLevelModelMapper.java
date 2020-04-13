package cz.xfabian.topicso.rest.difficulty.model;

import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.rest.model.AbstractModelMapper;

public class DifficultyLevelModelMapper extends AbstractModelMapper<DifficultyLevelModel, DifficultyLevel> {

    @Override
    public DifficultyLevelModel map(DifficultyLevel difficultyLevel) {
        return new DifficultyLevelModel(difficultyLevel.name(), difficultyLevel.getDisplayName());
    }
}
