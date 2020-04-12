package cz.xfabian.topicso.domain.video;

import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "video")
public class VideoEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String youtubeId;

    @Column(columnDefinition = "NUMERIC(2)")
    private Double rating;

    @Column(columnDefinition = "clob")
    private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    private CategoryEntity category;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level")
    private DifficultyLevel difficultyLevel;

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
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

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoEntity that = (VideoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(youtubeId, that.youtubeId) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category) &&
                Objects.equals(difficultyLevel, that.difficultyLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, youtubeId, rating, description, category, difficultyLevel);
    }
}
