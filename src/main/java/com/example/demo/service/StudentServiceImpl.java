package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    
    private final StudentRepository studentRepository;

    // 构造器注入
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public Student save(StudentDTO studentDTO){
        Student student=new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, StudentDTO studentDTO){
        Student student=studentRepository.findById(id)
        .orElseThrow(()->new RuntimeException("学生不存在："+id));

        student.setName(studentDTO.getName());
        student.setStudentNo(studentDTO.getStudentNo());
        student.setGender(studentDTO.getGender());
        student.setAge(studentDTO.getAge());
        student.setMajor(studentDTO.getMajor());
        student.setClassName(studentDTO.getClassName());
        student.setEmail(studentDTO.getEmail());

        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchByName(String name){
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public boolean isStudentNoExists(String studentNo){
        return studentRepository.existsByStudentNo(studentNo);
    }
}
