package com.thoughtworks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository<E> implements Repository<E> {

  private Map<String, E> entities = new HashMap<>();

  @Override
  public void save(String id, E entity) {
    entities.put(id, entity);
  }

  @Override
  public E get(String id) {
    return entities.get(id);
  }

  @Override
  public void delete(String id) {
    entities.remove(id);
  }

  @Override
  public void update(String id, E entity) {
    entities.put(id, entity);
  }

  @Override
  public List<E> list() {
    List<E> studentList = new LinkedList<>();
    for (String id : entities.keySet()) {
      studentList.add(entities.get(id));
    }
    return studentList;
  }
}
