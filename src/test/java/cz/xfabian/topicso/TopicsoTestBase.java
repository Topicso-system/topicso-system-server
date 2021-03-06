package cz.xfabian.topicso;

import cz.xfabian.topicso.entityfactory.TestEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@DirtiesContext
@Import(TestEntityFactory.class)
@TestPropertySource("classpath:application-test.properties")
public class TopicsoTestBase {

    @Autowired
    protected TestEntityFactory entityFactory;
}
