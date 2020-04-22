package cz.xfabian.topicso.core.youtube;

import cz.xfabian.topicso.TopicsoIntegrationTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class YouTubeServiceTest extends TopicsoIntegrationTestBase {

    @Autowired
    private YouTubeService youTubeService;

    @Test
    public void testGetVideoDetails() throws IOException {
        String youtubeId = "Ks-_Mh1QhMc";
        VideoDetails videoDetails = youTubeService.getVideoDetails(youtubeId);

        Assertions.assertAll("YouTubeService getVideoDetails",
                () -> Assert.assertEquals(youtubeId, videoDetails.getYoutubeId()),
                () -> Assert.assertEquals(getExpectedTitle(), videoDetails.getTitle()),
                () -> Assert.assertEquals(getExpectedDescription(), videoDetails.getDescription())
         );
    }

    private String getExpectedTitle() {
        return "Your body language may shape who you are | Amy Cuddy";
    }

    private String getExpectedDescription() {
        return "Body language affects how others see us, but it may also change how we see ourselves. Social psychologist Amy Cuddy argues that \"power posing\" -- standing in a posture of confidence, even when we don't feel confident -- can boost feelings of confidence, and might have an impact on our chances for success. (Note: Some of the findings presented in this talk have been referenced in an ongoing debate among social scientists about robustness and reproducibility. Read Amy Cuddy's response here: http://ideas.ted.com/inside-the-debate-about-power-posing-a-q-a-with-amy-cuddy/)\n\nGet TED Talks recommended just for you! Learn more at https://www.ted.com/signup.\n\nThe TED Talks channel features the best talks and performances from the TED Conference, where the world's leading thinkers and doers give the talk of their lives in 18 minutes (or less). Look for talks on Technology, Entertainment and Design -- plus science, business, global issues, the arts and more.\n\nFollow TED on Twitter: http://www.twitter.com/TEDTalks\nLike TED on Facebook: https://www.facebook.com/TED\n\nSubscribe to our channel: https://www.youtube.com/TED";
    }
}
