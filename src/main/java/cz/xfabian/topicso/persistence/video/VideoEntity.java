package cz.xfabian.topicso.persistence.video;

import cz.xfabian.topicso.persistence.category.CategoryEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "video")
public class VideoEntity {

    @Id
    @Access(AccessType.PROPERTY)
    private int id;

    private String title;

    private String youtubeId;

    private double rating;

    private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    private CategoryEntity category;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoEntity that = (VideoEntity) o;
        return id == that.id &&
                Double.compare(that.rating, rating) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(youtubeId, that.youtubeId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, youtubeId, rating, description, category);
    }
}
