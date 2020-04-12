package cz.xfabian.topicso.rest.video.model;

import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;

public class DifficultyLevelModelMapper {

    public DifficultyLevelModel map(DifficultyLevel difficultyLevel) {
        return new DifficultyLevelModel(difficultyLevel.name(), difficultyLevel.getDisplayName());
    }
}
