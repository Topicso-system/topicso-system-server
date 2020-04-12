package cz.xfabian.topicso.rest.difficulty;

import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModel;
import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DifficultyLevelControllerImpl implements DifficultyLevelController {

    @Override
    public List<DifficultyLevelModel> getAllDifficultyLevels() {
        return new DifficultyLevelModelMapper().map(DifficultyLevel.getAllDifficultyLevels());
    }
}
