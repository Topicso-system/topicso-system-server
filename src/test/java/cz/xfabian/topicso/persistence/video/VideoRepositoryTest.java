package cz.xfabian.topicso.persistence.video;

import cz.xfabian.topicso.TopicsoTestBase;
import cz.xfabian.topicso.persistence.category.CategoryEntity;
import cz.xfabian.topicso.persistence.category.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VideoRepositoryTest extends TopicsoTestBase {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryEntity categoryEntity;
    private VideoEntity videoEntity;

    @Before
    public void init() {
        categoryEntity = createCategory();
        videoEntity = createVideo();
        videoEntity.setCategory(categoryEntity);

        categoryEntity = categoryRepository.save(categoryEntity);
        videoEntity = videoRepository.save(videoEntity);
    }

    @Test
    public void saveAndLoadTest() {
        VideoEntity loadedVideo = videoRepository.findById(videoEntity.getId()).get();

        Assertions.assertAll("Video",
                () -> Assertions.assertEquals(videoEntity.getTitle(), loadedVideo.getTitle(), "Video title  is not correct"),
                () -> Assertions.assertEquals(videoEntity.getYoutubeId(), loadedVideo.getYoutubeId(), "Video youtubeId is not correct"),
                () -> Assertions.assertEquals(videoEntity.getDescription(), loadedVideo.getDescription(), "Video description is not correct"),
                () -> Assertions.assertEquals(videoEntity.getRating(), loadedVideo.getRating(), "Video rating is not correct"),
                () -> Assertions.assertEquals(videoEntity.getCategory().getId(), loadedVideo.getCategory().getId(), "Video category id is not correct")
        );
    }

    private VideoEntity createVideo() {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setTitle("Test video");
        videoEntity.setDescription("Test description");
        videoEntity.setYoutubeId("Test youtubeId");
        videoEntity.setRating(0.5);
        return videoEntity;
    }

    private CategoryEntity createCategory() {
        CategoryEntity category = new CategoryEntity();
        category.setName("TestCategory");
        category.setPicture("picture");
        category.setOrder(1);
        return category;
    }
}
