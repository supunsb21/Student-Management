package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveEmployee(@RequestBody Student student) {
        return new 
        ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new
        ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }

    @PutMapping("{id}")
        public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new
        ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);    
    }

    @DeleteMapping("{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }

}
