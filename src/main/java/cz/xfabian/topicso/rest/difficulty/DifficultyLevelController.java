package cz.xfabian.topicso.rest.difficulty;

import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface DifficultyLevelController {

    @GetMapping("/difficulties")
    List<DifficultyLevelModel> getAllDifficultyLevels();
}
