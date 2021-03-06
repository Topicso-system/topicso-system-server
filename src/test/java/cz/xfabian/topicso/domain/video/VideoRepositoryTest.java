package cz.xfabian.topicso.domain.video;

import cz.xfabian.topicso.domain.PersistenceTestBase;
import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.category.CategoryRepository;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class VideoRepositoryTest extends PersistenceTestBase {

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

    @Test
    public void findByCategoryTest() {
        CategoryEntity categoryA = persistedEntityFactory.persistedCategory("CategoryA");
        CategoryEntity categoryB = persistedEntityFactory.persistedCategory("CategoryB");

        VideoEntity aCategoryVideo1 = persistedEntityFactory.persistedVideo("aCategoryVideo1", categoryA);
        VideoEntity aCategoryVideo2 = persistedEntityFactory.persistedVideo("aCategoryVideo2", categoryA);
        VideoEntity bCategoryVideo = persistedEntityFactory.persistedVideo("bCategoryVideo", categoryB);

        ArrayList<VideoEntity> videosByCategoryA = videoRepository.findByCategory(categoryA.getId());

        Assert.assertEquals(List.of(aCategoryVideo1, aCategoryVideo2), videosByCategoryA);
    }

    @Test
    public void findByCategoryAndDifficultyTest() {
        CategoryEntity categoryA = persistedEntityFactory.persistedCategory("CategoryA");
        CategoryEntity categoryB = persistedEntityFactory.persistedCategory("CategoryB");

        VideoEntity aCategoryBeginner = persistedEntityFactory.persistedVideo("aCategoryVideo1", categoryA, DifficultyLevel.BEGINNER);
        VideoEntity aCategoryAdvanced1 = persistedEntityFactory.persistedVideo("aCategoryVideo2", categoryA, DifficultyLevel.ADVANCED);
        VideoEntity aCategoryAdvanced2 = persistedEntityFactory.persistedVideo("aCategoryVideo2", categoryA, DifficultyLevel.ADVANCED);
        VideoEntity bCategoryAdvanced = persistedEntityFactory.persistedVideo("bCategoryVideo", categoryB, DifficultyLevel.ADVANCED);

        ArrayList<VideoEntity> videosByCategoryA = videoRepository.findByCategoryAndDifficulty(categoryA.getId(), DifficultyLevel.ADVANCED);

        Assert.assertEquals(List.of(aCategoryAdvanced1, aCategoryAdvanced2), videosByCategoryA);
    }
}
