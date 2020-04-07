package cz.xfabian.topicso.rest;

import cz.xfabian.topicso.Launcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = Launcher.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class RestTestBase {

    @Autowired
    protected MockMvc mockClient;
}
