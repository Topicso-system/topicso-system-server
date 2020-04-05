package cz.xfabian.topicso.core.video;

import cz.xfabian.topicso.rest.video.dto.VideoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {

    List<VideoDTO> getVideos();

    void addVideo(VideoDTO video);
}
