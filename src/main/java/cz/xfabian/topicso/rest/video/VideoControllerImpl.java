package cz.xfabian.topicso.rest.video;

import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.persistence.video.VideoEntity;
import cz.xfabian.topicso.rest.video.model.VideoEntityModelMapper;
import cz.xfabian.topicso.rest.video.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoControllerImpl implements VideoController {

    @Autowired
    private VideoService videoService;

    @Override
    public List<VideoModel> getVideos() {
        List<VideoEntity> videoEntities = videoService.getVideos();
        return new VideoEntityModelMapper().map(videoEntities);
    }
}
