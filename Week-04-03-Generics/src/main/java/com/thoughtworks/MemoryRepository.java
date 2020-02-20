package com.thoughtworks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository<Student> {

  private Map<String, Student> students = new HashMap<>();

  @Override
  public void save(String id, Student student) {
    students.put(id, student);
  }

  @Override
  public Student get(String id) {
    return students.get(id);
  }

  @Override
  public void delete(String id) {
    students.remove(id);
  }

  @Override
  public void update(String id, Student student) {
    students.put(id, student);
  }

  @Override
  public List<Student> list() {
    List<Student> studentList = new LinkedList<>();
    for (String id : students.keySet()) {
      studentList.add(students.get(id));
    }
    return studentList;
  }
}
