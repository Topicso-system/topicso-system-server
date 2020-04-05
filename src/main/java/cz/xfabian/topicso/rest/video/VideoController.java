package cz.xfabian.topicso.rest.video;

import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.rest.video.dto.VideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public List<VideoDTO> getVideos() {
        return videoService.getVideos();
    }

}
