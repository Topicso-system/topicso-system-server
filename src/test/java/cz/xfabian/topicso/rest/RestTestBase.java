package cz.xfabian.topicso.rest;

import cz.xfabian.topicso.TopicsoTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class RestTestBase extends TopicsoTestBase {

    @Autowired
    protected MockMvc mockClient;
}
