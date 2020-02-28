package com.thoughtworks;

import java.util.List;

public interface Repository<E> {

  public abstract boolean save(String id, E entity);

  public abstract E get(String id);

  public abstract E delete(String id);

  public abstract boolean update(String id, E entity);

  public abstract List<E> list();
}
