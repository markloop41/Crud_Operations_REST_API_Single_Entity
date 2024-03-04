package com.kunal.CRUD_Operations.service;

import com.kunal.CRUD_Operations.model.request.AddStudentDto;
import com.kunal.CRUD_Operations.model.request.DeleteStudentDto;
import com.kunal.CRUD_Operations.model.request.UpdateStudentDto;
import com.kunal.CRUD_Operations.model.response.GetStudentDto;

import java.util.List;

public interface StudentService {
    GetStudentDto saveStudent(AddStudentDto addStudentDto);

    GetStudentDto getStudent(Integer studentId);

    List<GetStudentDto> getAllStudents();

    GetStudentDto updateStudent(Integer studentId, UpdateStudentDto updateStudentDto);

    DeleteStudentDto deleteStudent(Integer studentId);

    void deleteAllStudents();
}
