package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

  public static void main(String[] args) {
    //创建一些学生((3,张三)，(4,李四)，(5,王五)，(6,赵六)，(7,钱七))并保存进仓库
    List<Student> allStudents = Arrays.asList(
        new Student("3", "张三"),
        new Student("4", "李四"),
        new Student("5", "王五"),
        new Student("6", "赵六"),
        new Student("7", "钱七"));
    MemoryRepository studentRepository = new MemoryRepository();
    allStudents.forEach(student -> studentRepository.save(student.getId(), student));

    // 从仓库中获取张三并打印
    Student zhangSan = studentRepository.get("3");
    System.out.println(zhangSan);

    // 从仓库中删除李四
    studentRepository.delete("4");

    // 然后新建一个学生(5,冯五)替换仓库中的王五
    Student fengWu = new Student("5", "冯五");
    studentRepository.update(fengWu.getId(), fengWu);

    // 获取仓库中的所有学生并用 printList 方法打印到控制台
    List<Student> studentList = studentRepository.list();
    RepositoryUtil.printList(studentList);
  }
}
