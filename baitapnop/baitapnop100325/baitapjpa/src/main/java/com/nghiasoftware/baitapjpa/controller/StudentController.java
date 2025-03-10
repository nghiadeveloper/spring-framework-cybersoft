package com.nghiasoftware.baitapjpa.controller;

import com.nghiasoftware.baitapjpa.dto.StudentDTO;
import com.nghiasoftware.baitapjpa.entity.Students;
import com.nghiasoftware.baitapjpa.services.StudentService;
import com.nghiasoftware.baitapjpa.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentServiceImp.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = (StudentDTO) studentServiceImp.addStudents((List<StudentDTO>) studentDTO);
        return ResponseEntity.status(201).body(savedStudent);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentDTO>> getStudentsByName(@RequestParam String name) {
        List<StudentDTO> students = studentServiceImp.getStudentsByName(name);
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentServiceImp.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
