package cz.xfabian.topicso.config;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YouTubeConfiguration {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private static YouTube youTube;


    @Bean
    public YouTube getYouTube() {
        return new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, httpRequest -> { })
                .setApplicationName("Topicso")
                .build();
    }
}
