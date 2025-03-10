package com.nghiasoftware.baitapjpa.services;

import com.nghiasoftware.baitapjpa.dto.StudentDTO;
import com.nghiasoftware.baitapjpa.entity.Students;
import com.nghiasoftware.baitapjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImp {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Students> studentsList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Students students : studentsList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(students.getId());
            studentDTO.setName(students.getName());
            studentDTO.setEmail(students.getEmail());
            studentDTO.setAge(students.getAge());

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> addStudents(List<StudentDTO> studentDTOs) {
        List<StudentDTO> addedStudents = new ArrayList<>();

        for (StudentDTO studentDTO : studentDTOs) {
            Students student = new Students(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
            Students savedStudent = studentRepository.save(student);

            StudentDTO addedStudentDTO = new StudentDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getEmail(),
                savedStudent.getAge()
            );
            addedStudents.add(addedStudentDTO);
        }
        return addedStudents;
    }

    @Override
    public List<StudentDTO> getStudentsByName(String name) {
        List<Students> students = studentRepository.findByName(name);
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Students student : students) {
            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getAge());
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

}
