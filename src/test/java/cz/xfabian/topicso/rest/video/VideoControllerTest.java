package cz.xfabian.topicso.rest.video;

import com.google.common.collect.ImmutableList;
import cz.xfabian.topicso.core.video.VideoService;
import cz.xfabian.topicso.persistence.video.VideoEntity;
import cz.xfabian.topicso.rest.RestTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class VideoControllerTest extends RestTestBase {

    @MockBean
    private VideoService videoService;

    @Test
    public void getVideosTest() throws Exception {
        VideoEntity video = entityFactory.createVideo();

        Mockito.when(videoService.getVideos()).thenReturn(ImmutableList.of(video));

        mockClient.perform(get("/videos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(video.getId())))
                .andExpect(jsonPath("$[0].title", is(video.getTitle())))
                .andExpect(jsonPath("$[0].youtubeId", is(video.getYoutubeId())))
                .andExpect(jsonPath("$[0].rating", is(video.getRating())))
                .andExpect(jsonPath("$[0].description", is(video.getDescription())));
    }
}
