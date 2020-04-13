package cz.xfabian.topicso.rest.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.domain.category.CategoryEntity;
import cz.xfabian.topicso.domain.video.VideoEntity;
import cz.xfabian.topicso.rest.video.model.VideoEntityModelMapper;
import cz.xfabian.topicso.rest.video.model.VideoModel;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class VideoEntityModelMapperTest extends AbstractEntityModelMapperTest<VideoEntity, VideoModel> {
    @Override
    protected void assertEntityModel(VideoEntity entity, VideoModel videoModel) {
        Assertions.assertAll("CategoryEntity to CategoryModel",
                () -> Assert.assertEquals(entity.getId(), videoModel.getId()),
                () -> Assert.assertEquals(entity.getTitle(), videoModel.getTitle()),
                () -> Assert.assertEquals(entity.getDescription(), videoModel.getDescription()),
                () -> Assert.assertEquals(entity.getDifficultyLevel().getDisplayName(), videoModel.getDifficulty().getDisplayName()),
                () -> Assert.assertEquals(entity.getDifficultyLevel().name(), videoModel.getDifficulty().getID()),
                () -> Assert.assertEquals(entity.getYoutubeId(), videoModel.getYoutubeId()),
                () -> Assert.assertEquals(entity.getRating(), videoModel.getRating())
        );
    }

    @Override
    protected ModelMapper<VideoModel, VideoEntity> getMapper() {
        return new VideoEntityModelMapper();
    }

    @Override
    protected List<VideoEntity> getEntities() {
        CategoryEntity category = entityFactory.createCategory();
        return ImmutableList.of(
                entityFactory.createVideo("Video1", category),
                entityFactory.createVideo());
    }
}
