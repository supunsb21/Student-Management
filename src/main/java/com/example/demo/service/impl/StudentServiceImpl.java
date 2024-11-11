package com.example.demo.service.impl;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override 
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override 
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return student.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
            () -> new RuntimeException()
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override 
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(
            () -> new RuntimeException()
         );
        studentRepository.deleteById(id);
    }
    
}
