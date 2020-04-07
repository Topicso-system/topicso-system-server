package cz.xfabian.topicso.rest.video.model;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.persistence.video.VideoEntity;

import java.util.List;

public class VideoEntityModelMapper {

    public List<VideoModel> map(List<VideoEntity> videoEntities) {
        ImmutableList.Builder<VideoModel> videoModelListBuilder = ImmutableList.builder();

        for (VideoEntity videoEntity: videoEntities) {
            videoModelListBuilder.add(map(videoEntity));
        }

        return videoModelListBuilder.build();
    }

    public VideoModel map(VideoEntity videoEntity) {
        VideoModel videoModel = new VideoModel();
        videoModel.setId(videoEntity.getId());
        videoModel.setTitle(videoEntity.getTitle());
        videoModel.setYoutubeId(videoEntity.getYoutubeId());
        videoModel.setDescription(videoEntity.getDescription());
        videoModel.setRating(videoEntity.getRating());
        return videoModel;
    }
}
