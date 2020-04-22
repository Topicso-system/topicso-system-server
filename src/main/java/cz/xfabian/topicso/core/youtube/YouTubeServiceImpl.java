package cz.xfabian.topicso.core.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class YouTubeServiceImpl implements YouTubeService {

    @Value("${youtube.api.uri}")
    private String youtubeApiUri;

    @Value("${youtube.api.key}")
    private String youtubeApiKey;

    @Autowired
    private YouTube youTube;

    @Override
    public VideoDetails getVideoDetails(String youtubeVideoId) throws IOException {
        VideoListResponse response = youTube.videos()
                .list("id, snippet")
                .setKey(youtubeApiKey)
                .setId(youtubeVideoId)
                .execute();

        return toVideoDetails(response);
    }

    private VideoDetails toVideoDetails(VideoListResponse response)
    {
        Video video = response.getItems().get(0);
        String yotubeId = video.getId();
        String title = video.getSnippet().getTitle();
        String description = video.getSnippet().getDescription();

        return new VideoDetails(yotubeId, title, description);
    }
}
