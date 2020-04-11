package cz.xfabian.topicso.rest.video;

import cz.xfabian.topicso.rest.video.model.VideoModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface VideoController {

    @GetMapping("/videos")
    List<VideoModel> getVideos();

    @GetMapping("/categories/{categoryId}/videos")
    List<VideoModel> getVideosByCategory(@PathVariable int categoryId);
}
