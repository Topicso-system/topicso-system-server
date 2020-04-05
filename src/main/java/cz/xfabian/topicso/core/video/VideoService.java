package cz.xfabian.topicso.core.video;

import cz.xfabian.topicso.rest.video.dto.VideoDTO;

import java.util.List;

public interface VideoService {

    List<VideoDTO> getVideos();

    void addVideo(VideoDTO video);
}
