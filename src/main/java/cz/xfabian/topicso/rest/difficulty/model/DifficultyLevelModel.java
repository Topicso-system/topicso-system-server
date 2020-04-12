package cz.xfabian.topicso.rest.difficulty.model;

public class DifficultyLevelModel {

    private String displayName;
    private String ID;

    public DifficultyLevelModel(String ID, String displayName) {
        this.displayName = displayName;
        this.ID = ID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getID() {
        return ID;
    }
}
