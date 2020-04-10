package cz.xfabian.topicso.entityfactory;

import cz.xfabian.topicso.persistence.category.CategoryEntity;
import cz.xfabian.topicso.persistence.video.VideoEntity;
import org.springframework.stereotype.Component;

@Component
public class TestEntityFactory {

    // Categories
    public CategoryEntity createCategory() {
        return createCategory("TestCategory", null);
    }

    public CategoryEntity createCategory(String categoryName) {
        return createCategory(categoryName, null);
    }

    public CategoryEntity createCategory(String categoryName, CategoryEntity parent) {
        CategoryEntity category = new CategoryEntity();
        category.setId(-1);
        category.setName(categoryName);
        category.setPicture("picture");
        category.setOrder(1);
        category.setParent(parent);
        return category;
    }

    // Videos
    public VideoEntity createVideo() {
        return createVideo("TestVideo", null);
    }

    public VideoEntity createVideo(CategoryEntity categoryEntity) {
        return createVideo("TestVideo", categoryEntity);
    }

    public VideoEntity createVideo(String title, CategoryEntity category) {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setId(-1);
        videoEntity.setTitle(title);
        videoEntity.setDescription("Test description");
        videoEntity.setYoutubeId("Test youtubeId");
        videoEntity.setRating(0.5);
        videoEntity.setCategory(category);
        return videoEntity;
    }
}
