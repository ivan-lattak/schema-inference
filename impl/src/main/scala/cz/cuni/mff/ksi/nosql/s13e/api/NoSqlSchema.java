package cz.cuni.mff.ksi.nosql.s13e.api;

import java.util.List;

public interface NoSqlSchema {

    String getName();

    List<Entity> getEntities();

    List<String> getEntityNames();

    Entity getEntity(String name);

}
