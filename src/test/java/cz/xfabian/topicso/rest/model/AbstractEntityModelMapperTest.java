package cz.xfabian.topicso.rest.model;

import cz.xfabian.topicso.TopicsoTestBase;
import org.junit.Test;

import java.util.List;

public abstract class AbstractEntityModelMapperTest<ENTITY, MODEL> extends TopicsoTestBase {

    @Test
    public void mapEntityListToModelListTest() {
        validate();
        List<ENTITY> entities = getEntities();
        List<MODEL> models = getMapper().map(entities);

        for (int i = 0; i < entities.size(); i++) {
            assertEntityModel(entities.get(i), models.get(i));
        }
    }

    @Test
    public void mapEntityToModelTest() {
        validate();
        ENTITY entity = getEntities().get(0);
        MODEL model = getMapper().map(entity);
        assertEntityModel(entity, model);
    }

    private void validate() {
        if (getMapper() == null) throw new IllegalStateException("Implement the getMapper method so it returns the correct mapper!");
        if (getEntities().size() < 2) throw new IllegalStateException("Implement the getEntities method so it returns at least 2 entities!");
    }

    protected abstract void assertEntityModel(ENTITY entity, MODEL model);

    protected abstract ModelMapper<MODEL, ENTITY> getMapper();

    protected abstract List<ENTITY> getEntities();
}
