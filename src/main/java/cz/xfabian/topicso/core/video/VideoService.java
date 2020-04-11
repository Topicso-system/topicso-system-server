package cz.xfabian.topicso.core.video;

import cz.xfabian.topicso.persistence.video.VideoEntity;

import java.util.List;

public interface VideoService {

    List<VideoEntity> getVideos();

    List<VideoEntity> getVideosByCategory(int categoryId);

    void addVideo(VideoEntity video);
}
