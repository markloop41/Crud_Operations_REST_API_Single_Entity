package com.kunal.CRUD_Operations.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kunal.CRUD_Operations.entity.Student;
import com.kunal.CRUD_Operations.model.request.AddStudentDto;
import com.kunal.CRUD_Operations.model.request.DeleteStudentDto;
import com.kunal.CRUD_Operations.model.request.UpdateStudentDto;
import com.kunal.CRUD_Operations.model.response.GetStudentDto;
import com.kunal.CRUD_Operations.repository.StudentRepository;
import com.kunal.CRUD_Operations.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    @Override
    public GetStudentDto saveStudent(AddStudentDto addStudentDto) {
        Student student = Student.builder().name(addStudentDto.getName()).age(addStudentDto.getAge()).grade(addStudentDto.getGrade()).build();
        studentRepository.save(student);
        return GetStudentDto.builder().id(student.getId()).name(student.getName()).age(student.getAge()).grade(student.getGrade()).build();
    }

    @Override
    public GetStudentDto getStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return GetStudentDto.builder().id(student.getId()).name(student.getName()).age(student.getAge()).grade(student.getGrade()).build();
    }

    @Override
    public List<GetStudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        GetStudentDto getStudentDto = new GetStudentDto();
        ObjectMapper objectMapper = new ObjectMapper();
        List<GetStudentDto> getStudentDtos = students.stream().map(student -> objectMapper.convertValue(student, GetStudentDto.class)).collect(Collectors.toList());
        return getStudentDtos;
    }

    @Override
    public GetStudentDto updateStudent(Integer studentId, UpdateStudentDto updateStudentDto) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setName(updateStudentDto.getName());
        student.setAge(updateStudentDto.getAge());
        student.setGrade(updateStudentDto.getGrade());
        studentRepository.save(student);
        return GetStudentDto.builder().id(student.getId()).name(student.getName()).age(student.getAge()).grade(student.getGrade()).build();
    }

    @Override
    public DeleteStudentDto deleteStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        DeleteStudentDto deleteStudentDto = DeleteStudentDto.builder().name(student.getName()).age(student.getAge()).grade(student.getGrade()).build();
        studentRepository.delete(student);
        return deleteStudentDto;
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
