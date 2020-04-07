package cz.xfabian.topicso;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@DirtiesContext
@TestPropertySource("classpath:application-test.properties")
public class TopicsoTestBase {
}
