package cz.xfabian.topicso.rest.model;

import java.util.List;

public interface ModelMapper<MODEL, ENTITY> {

    List<MODEL> map(List<ENTITY> entities);

    MODEL map(ENTITY entity);
}
