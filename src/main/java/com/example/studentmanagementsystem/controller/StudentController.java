package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    //  show the edit form with existing data
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-form";
    }

    // Save the student from the form
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        // If there are validation errors, return to the form
        if (result.hasErrors()) {
            return "student-form";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }


}
