package cz.xfabian.topicso.domain.difficulty;

import java.util.Arrays;
import java.util.List;

public enum DifficultyLevel {
    BEGINNER("Beginner"),
    ADVANCED("Advanced"),
    INTERMEDIATE("Intermediate");

    private final String displayName;

    DifficultyLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static List<DifficultyLevel> getAllDifficultyLevels() {
        return Arrays.asList(DifficultyLevel.values());
    }
}
