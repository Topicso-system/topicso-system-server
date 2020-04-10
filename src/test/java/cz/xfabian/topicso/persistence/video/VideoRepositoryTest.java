package cz.xfabian.topicso.persistence.video;

import cz.xfabian.topicso.TopicsoTestBase;
import cz.xfabian.topicso.persistence.category.CategoryEntity;
import cz.xfabian.topicso.persistence.category.CategoryRepository;
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

    @Test
    public void saveAndLoadTest() {
        CategoryEntity persistedCategory = persistedEntityFactory.persistedCategory();
        VideoEntity persistedVideo = persistedEntityFactory.persistedVideo(persistedCategory);

        VideoEntity loadedVideo = videoRepository.findById(persistedVideo.getId()).get();

        Assertions.assertAll("Video",
                () -> Assertions.assertEquals(persistedVideo.getTitle(), loadedVideo.getTitle(), "Video title  is not correct"),
                () -> Assertions.assertEquals(persistedVideo.getYoutubeId(), loadedVideo.getYoutubeId(), "Video youtubeId is not correct"),
                () -> Assertions.assertEquals(persistedVideo.getDescription(), loadedVideo.getDescription(), "Video description is not correct"),
                () -> Assertions.assertEquals(persistedVideo.getRating(), loadedVideo.getRating(), "Video rating is not correct"),
                () -> Assertions.assertEquals(persistedVideo.getCategory().getId(), loadedVideo.getCategory().getId(), "Video category id is not correct")
        );
    }
}
