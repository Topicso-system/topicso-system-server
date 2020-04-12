package cz.xfabian.topicso.entityfactory;

import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.category.CategoryRepository;
import cz.xfabian.topicso.domain.difficulty.DifficultyLevel;
import cz.xfabian.topicso.domain.video.VideoEntity;
import cz.xfabian.topicso.domain.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestPersistedEntityFactory {

    @Autowired
    private TestEntityFactory entityFactory;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Category
    public CategoryEntity persistedCategory() {
        return persistedCategory("TestCategory", null);
    }

    public CategoryEntity persistedCategory(String categoryName) {
        return persistedCategory(categoryName, null);
    }

    public CategoryEntity persistedCategory(String categoryName, CategoryEntity parent) {
        return categoryRepository.save(entityFactory.createCategory(categoryName, parent));
    }

    // Video
    public VideoEntity persistedVideo() {
        return videoRepository.save(entityFactory.createVideo());
    }

    public VideoEntity persistedVideo(CategoryEntity category) {
        return videoRepository.save(entityFactory.createVideo(category));
    }

    public VideoEntity persistedVideo(String videoTitle, CategoryEntity categoryEntity) {
        return videoRepository.save(entityFactory.createVideo(videoTitle, categoryEntity));
    }

    public VideoEntity persistedVideo(String videoTitle, CategoryEntity categoryEntity, DifficultyLevel difficulty) {
        return videoRepository.save(entityFactory.createVideo(videoTitle, categoryEntity, difficulty));
    }
}
