package cz.xfabian.topicso.rest.video.model;

import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModel;

import java.util.Objects;

public class VideoModel {

    private Integer id;
    private String title;
    private String youtubeId;
    private double rating;
    private String description;
    private DifficultyLevelModel difficulty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DifficultyLevelModel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevelModel difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoModel that = (VideoModel) o;
        return Double.compare(that.rating, rating) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(youtubeId, that.youtubeId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(difficulty, that.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, youtubeId, rating, description, difficulty);
    }
}
