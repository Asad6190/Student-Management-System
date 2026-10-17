package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show the list of all students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // This tells Thymeleaf to look for students.html
    }

    // Show the form to add a new student
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form"; // Looks for student-form.html
    }

    // Save the student from the form
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students"; // Redirect to the list after saving
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
