package cz.xfabian.topicso.persistence;

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
        category.setName(categoryName);
        category.setPicture("picture");
        category.setOrder(1);
        category.setParent(parent);
        return category;
    }

    // Videos
    public VideoEntity createVideo() {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setTitle("Test video");
        videoEntity.setDescription("Test description");
        videoEntity.setYoutubeId("Test youtubeId");
        videoEntity.setRating(0.5);
        return videoEntity;
    }
}
