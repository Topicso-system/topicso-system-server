package cz.xfabian.topicso.domain;

import cz.xfabian.topicso.TopicsoTestBase;
import cz.xfabian.topicso.entityfactory.TestPersistedEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(TestPersistedEntityFactory.class)
public class PersistenceTestBase extends TopicsoTestBase {

    @Autowired
    protected TestPersistedEntityFactory persistedEntityFactory;
}
