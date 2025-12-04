package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    // 根据学号查找
    Optional<Student> findByStudentNo(String studentNo);

    // 根据姓名模糊查询
    List<Student> findByNameContaining(String name);

    // 根据专业查询
    List<Student> findByMajor(String major);

    // 自定义：根据班级查询
    @Query("SELECT s FROM Student s WHERE s.className=?1")
    List<Student> findByClass(String className);

    // 检查学号是否存在
    boolean existsByStudentNo(String studentNo);
}
