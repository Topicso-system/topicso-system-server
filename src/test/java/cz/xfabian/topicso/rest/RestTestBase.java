package cz.xfabian.topicso.rest;

import cz.xfabian.topicso.Launcher;
import cz.xfabian.topicso.TopicsoTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = Launcher.class)
@AutoConfigureMockMvc
public class RestTestBase extends TopicsoTestBase {

    @Autowired
    protected MockMvc mockClient;
}
