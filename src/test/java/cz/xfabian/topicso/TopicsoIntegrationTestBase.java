package cz.xfabian.topicso;

import cz.xfabian.topicso.entityfactory.TestPersistedEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ComponentScan
@AutoConfigureMockMvc
public class TopicsoIntegrationTestBase extends TopicsoTestBase {

    @Autowired
    protected TestPersistedEntityFactory persistedEntityFactory;

    @Autowired
    protected MockMvc mockClient;
}
