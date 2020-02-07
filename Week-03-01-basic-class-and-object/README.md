## 作业要求：

* 在src目录下面创建一个包model.
* 在model下面创建一个学生类(Student).
* 学生类有姓名、年龄、性别3个属性和学习、休息2个方法(方法内容都打印一句话即可)。
* 在model外部的Application类里创建学生(李莉,20岁,女)，并打印出学生的所有属性并调用学习和休息方法。

* 在model中创建一个教师类(Teacher)
* 教师有姓名和管理学生的名单(用Student数组实现)2个属性，教师有添加学生和查看所有管理学生的方法
* 在model外部的Application类中创建教师(张龙，管理学生信息:[(李莉，20岁，女)，(王其，21岁，男)])，并给张龙老师添加一名学生(赵毅，22岁，男)，最后查看张龙老师所有管理学生


**使用简介**  
1. 如何导入gradle项目(现在不要求掌握什么是gradle)
- https://www.youtube.com/watch?v=0s7YYjQEsfU
- https://www.jetbrains.com/help/idea/gradle.html

2.运行所有测试  
```
./gradlew test
```
3. 运行单个测试可以直接点击对应测试右边的绿色三角形
