package com.nghiasoftware.baitapjpa.services;

import com.nghiasoftware.baitapjpa.dto.StudentDTO;

import java.util.List;

public interface StudentServiceImp {
    List<StudentDTO> getAllStudents();
    List<StudentDTO> addStudents(List<StudentDTO> studentDTOs);
    List<StudentDTO> getStudentsByName(String name);
    void deleteStudent(int id);
}
