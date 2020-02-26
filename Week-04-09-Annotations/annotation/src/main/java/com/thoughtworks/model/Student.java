package com.thoughtworks.model;

// 为Student类添加一个Alias注解, 表明Student类可以取一个自定义的别名
@Alias(aliasName = "aliasName")
public class Student {
    @Limit(min = 1, max = 140)
    // 为age字段添加一个Limit注解, 表明age字段的最小值为1 最大值为140
    private int age;

}
