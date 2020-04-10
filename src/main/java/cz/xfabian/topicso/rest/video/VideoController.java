package cz.xfabian.topicso.rest.video;

import cz.xfabian.topicso.rest.video.model.VideoModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/videos")
public interface VideoController {

    @GetMapping
    List<VideoModel> getVideos();
}
