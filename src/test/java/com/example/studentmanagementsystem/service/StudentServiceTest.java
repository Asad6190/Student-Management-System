package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Tells JUnit to use Mockito
public class StudentServiceTest {

    // 1. Create a fake version of the repository
    @Mock
    private StudentRepository studentRepository;

    // 2. Inject the fake repository into the real service implementation
    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testGetAllStudents() {
        // --- ARRANGE (Set up the fake data) ---
        Student student1 = new Student();
        student1.setFirstName("Asad");
        student1.setLastName("Mehmood");
        student1.setEmail("asad@test.com");

        Student student2 = new Student();
        student2.setFirstName("John");
        student2.setLastName("Doe");
        student2.setEmail("john@test.com");

        // Tell the fake repository what to do when findAll() is called
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        // --- ACT (Call the actual service method) ---
        List<Student> result = studentService.getAllStudents();

        // --- ASSERT (Check if the result is correct) ---
        assertEquals(2, result.size()); // Check that we got 2 students
        assertEquals("Asad", result.get(0).getFirstName()); // Check the first name of the first student
    }
}
