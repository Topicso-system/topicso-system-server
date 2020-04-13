package cz.xfabian.topicso.rest.cors;

import cz.xfabian.topicso.TopicsoIntegrationTestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CorsIT extends TopicsoIntegrationTestBase {

    @Value( "${cors.client}" )
    private String allowedOrigin;

    private static Stream<Arguments> requests() {
        return Stream.of(
                Arguments.of("/videos", HttpMethod.GET),
                Arguments.of("/categories/1/videos", HttpMethod.GET),
                Arguments.of("/categories", HttpMethod.GET),
                Arguments.of("/difficulties", HttpMethod.GET)
        );
    }

    @ParameterizedTest
    @MethodSource("requests")
    public void corsAllowedTest(String urlTemplate, HttpMethod httpMethod) throws Exception {
        mockClient.perform(get(urlTemplate)
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, httpMethod)
                .header(HttpHeaders.ORIGIN, allowedOrigin)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @MethodSource("requests")
    public void corsDisallowedTest(String urlTemplate, HttpMethod httpMethod) throws Exception {
        mockClient.perform(get( urlTemplate)
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, httpMethod)
                .header(HttpHeaders.ORIGIN, "http://localhost:4000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
