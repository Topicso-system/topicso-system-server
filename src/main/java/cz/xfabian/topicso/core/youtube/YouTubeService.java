package cz.xfabian.topicso.core.youtube;

import java.io.IOException;

public interface YouTubeService {

    VideoDetails getVideoDetails(String youtubeVideoId) throws IOException;
}
