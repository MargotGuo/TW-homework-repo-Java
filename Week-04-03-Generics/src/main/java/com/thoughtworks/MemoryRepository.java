package com.thoughtworks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository<E> implements Repository<E> {

  private Map<String, E> entities = new HashMap<>();

  @Override
  public boolean save(String id, E entity) {
    if (entities.containsKey(id)) {
      return false;
    }
    entities.put(id, entity);
    return true;
  }

  @Override
  public E get(String id) {
    return entities.get(id);
  }

  @Override
  public E delete(String id) {
    return entities.remove(id);
  }

  @Override
  public boolean update(String id, E entity) {
    if (entities.containsKey(id)) {
      entities.put(id, entity);
      return true;
    }
    return false;
  }

  @Override
  public List<E> list() {
    List<E> list = new LinkedList<>();
    for (String id : entities.keySet()) {
      list.add(entities.get(id));
    }
    return list;
  }
}
