package com.thoughtworks;

import java.util.List;

public interface Repository<E> {

  public abstract void save(String id, E entity);

  public abstract E get(String id);

  public abstract void delete(String id);

  public abstract void update(String id, E entity);

  public abstract List<E> list();
}
