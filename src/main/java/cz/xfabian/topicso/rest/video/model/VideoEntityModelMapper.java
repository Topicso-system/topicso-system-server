package cz.xfabian.topicso.rest.video.model;

import cz.xfabian.topicso.domain.video.VideoEntity;
import cz.xfabian.topicso.rest.model.AbstractModelMapper;
import cz.xfabian.topicso.rest.difficulty.model.DifficultyLevelModelMapper;

public class VideoEntityModelMapper extends AbstractModelMapper<VideoModel, VideoEntity> {

    @Override
    public VideoModel map(VideoEntity videoEntity) {
        VideoModel videoModel = new VideoModel();
        videoModel.setId(videoEntity.getId());
        videoModel.setTitle(videoEntity.getTitle());
        videoModel.setYoutubeId(videoEntity.getYoutubeId());
        videoModel.setDescription(videoEntity.getDescription());
        videoModel.setRating(videoEntity.getRating());
        videoModel.setDifficulty(new DifficultyLevelModelMapper().map(videoEntity.getDifficultyLevel()));
        return videoModel;
    }
}
