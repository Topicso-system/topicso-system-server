package cz.xfabian.topicso.rest.model;

import com.google.common.collect.ImmutableList;

import java.util.List;

public abstract class AbstractModelMapper<MODEL, ENTITY> implements ModelMapper<MODEL, ENTITY> {

    public List<MODEL> map(List<ENTITY> entities) {
        ImmutableList.Builder<MODEL> modelListBuilder = ImmutableList.builder();

        for (ENTITY entity: entities) {
            modelListBuilder.add(map(entity));
        }

        return modelListBuilder.build();
    }

    public abstract MODEL map(ENTITY entity);
}
