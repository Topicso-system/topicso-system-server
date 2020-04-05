package cz.xfabian.topicso.core.video;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.rest.video.dto.VideoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private List<VideoDTO> videos = new ArrayList<>();

    @Override
    public List<VideoDTO> getVideos() {
        return ImmutableList.copyOf(videos);
    }

    @Override
    public void addVideo(VideoDTO video) {
        videos.add(video);
    }
}
