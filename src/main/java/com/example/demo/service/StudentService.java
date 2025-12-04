package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    
    // 获取所有学生
    List<Student> findAll();

    // 根据ID获取学生
    Optional<Student> findById(Long id);

    // 添加学生
    Student save(StudentDTO studentDTO);

    // 更新学生
    Student update(Long id, StudentDTO studentDTO);

    // 删除学生
    void deleteById(Long id);

    // 根据姓名搜索
    List<Student> searchByName(String name);

    // 检查学号是否存在
    boolean isStudentNoExists(String studentNo);
}
