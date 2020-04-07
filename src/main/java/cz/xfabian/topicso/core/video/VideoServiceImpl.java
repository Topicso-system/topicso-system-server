package cz.xfabian.topicso.core.video;

import cz.xfabian.topicso.persistence.video.VideoEntity;
import cz.xfabian.topicso.persistence.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<VideoEntity> getVideos() {
        return videoRepository.findAll();
    }

    @Override
    public void addVideo(VideoEntity video) {
        videoRepository.save(video);
    }
}
