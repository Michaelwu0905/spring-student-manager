package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController{

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    // 首页，显示学生列表
    @GetMapping
    public String index(Model model){
        List<Student> students=studentService.findAll();
        model.addAttribute("students",students);
        return "index";
    }

    // 显示添加表单
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("student",new StudentDTO());
        return "add";
    }

    // 处理添加请求
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                             BindingResult result,
                             RedirectAttributes redirectAttributes){
        
        // 校验错误
        if(result.hasErrors()){
            return "add";
        }

        // 检查学号是否重复
        if(studentService.isStudentNoExists(studentDTO.getStudentNo())){
            result.rejectValue("studentNo","error.student","学号已存在");
        }

        studentService.save(studentDTO);
        redirectAttributes.addFlashAttribute("message","添加成功！");
        return "redirect:/students";
    }

    // 显示编辑表单
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Student student=studentService.findById(id).orElseThrow(()->new RuntimeException("学生不存在"));

        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setStudentNo(student.getStudentNo());
        studentDTO.setGender(student.getGender());
        studentDTO.setAge(student.getAge());
        studentDTO.setMajor(student.getMajor());
        studentDTO.setClassName(student.getClassName());
        studentDTO.setEmail(student.getEmail());

        model.addAttribute("student",studentDTO);
        return "edit";
    }

    // 处理更新请求
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id,
        @Valid @ModelAttribute("student") StudentDTO studentDTO,
        BindingResult result,
        RedirectAttributes redirectAttributes){
        
        if(result.hasErrors()){
            return "edit";
        }

        studentService.update(id,studentDTO);
        redirectAttributes.addFlashAttribute("message", "更新成功！");
        return "redirect:/students";
    }

    // 删除学生
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id,
        RedirectAttributes redirectAttributes){

        studentService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","删除成功！");
        return "redirect:/students";
    }

    // 搜索学生
    @GetMapping("/search")
    public String searchStudents(@RequestParam String keyword, Model model){
        List<Student> students=studentService.searchByName(keyword);
        model.addAttribute("students",students);
        model.addAttribute("keyword",keyword);
        return "index";
    }

}