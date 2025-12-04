# Spring-Student-Manager
这是一个用于学习java基本语法，入门springboot开发的简易springboot项目。感谢Claude老师，ChatGPT老师手把手带我入门Java开发。

## 项目结构
```
student-management/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── student/
│       │               ├── StudentApplication.java          # 启动类
│       │               ├── controller/
│       │               │   └── StudentController.java       # 控制器
│       │               ├── service/
│       │               │   ├── StudentService.java          # 服务接口
│       │               │   └── StudentServiceImpl.java      # 服务实现
│       │               ├── repository/
│       │               │   └── StudentRepository.java       # 数据访问层
│       │               ├── entity/
│       │               │   └── Student.java                 # 实体类
│       │               └── dto/
│       │                   └── StudentDTO.java              # 数据传输对象
│       └── resources/
│           ├── application.yml                              # 配置文件
│           └── templates/
│               ├── index.html                               # 首页
│               ├── add.html                                 # 添加页面
│               └── edit.html                                # 编辑页面
```

## 运行方法
在终端运行：
```
git clone https://github.com/Michaelwu0905/spring-student-manager.git
```
进入文件根目录，运行

```
./mvnw spring-boot:run
```
Windows:
```
mvnw.cmd spring-boot:run
```

之后在浏览器访问http://localhost:8080即可