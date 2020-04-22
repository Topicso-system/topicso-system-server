package cz.xfabian.topicso.core.youtube;

public class VideoDetails {

    private String youtubeId;
    private String description;
    private String title;

    public VideoDetails(String youtubeId, String title, String description) {
        this.youtubeId = youtubeId;
        this.description = description;
        this.title = title;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
