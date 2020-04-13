package cz.xfabian.topicso.rest.config;

import cz.xfabian.topicso.TopicsoIntegrationTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorsIT extends TopicsoIntegrationTestBase {

    @Value( "${cors.client}" )
    private String allowedOrigin;

    @Test
    public void corsAllowedTest() throws Exception {
        mockClient.perform(get("/videos")
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpMethod.GET)
                .header(HttpHeaders.ORIGIN, allowedOrigin)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void corsDisallowedTest() throws Exception {
        mockClient.perform(get("/videos")
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpMethod.GET)
                .header(HttpHeaders.ORIGIN, "http://localhost:4000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
