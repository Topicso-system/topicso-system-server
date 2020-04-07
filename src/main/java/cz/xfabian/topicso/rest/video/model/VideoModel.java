package cz.xfabian.topicso.rest.video.model;

import java.util.Objects;

public class VideoModel {

    private int id;
    private String title;
    private String youtubeId;
    private double rating;
    private String description;

    public VideoModel(int id, String title, String youtubeId, double rating, String description) {
        this.id = id;
        this.title = title;
        this.youtubeId = youtubeId;
        this.rating = rating;
        this.description = description;
    }

    public VideoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoModel videoDTO = (VideoModel) o;
        return id == videoDTO.id &&
                Double.compare(videoDTO.rating, rating) == 0 &&
                Objects.equals(title, videoDTO.title) &&
                Objects.equals(youtubeId, videoDTO.youtubeId) &&
                Objects.equals(description, videoDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, youtubeId, rating, description);
    }
}
