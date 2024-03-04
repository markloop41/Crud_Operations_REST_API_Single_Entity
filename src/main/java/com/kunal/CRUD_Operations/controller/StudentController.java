package com.kunal.CRUD_Operations.controller;


import com.kunal.CRUD_Operations.model.request.AddStudentDto;
import com.kunal.CRUD_Operations.model.request.UpdateStudentDto;
import com.kunal.CRUD_Operations.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@AllArgsConstructor
@Validated
public class StudentController {

    private StudentService studentService;

    @PostMapping("")
    public ResponseEntity<Object>saveStudent(@RequestBody AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(addStudentDto));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Object>getStudent(@PathVariable Integer studentId){
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudent(studentId));
    }

    @GetMapping("")
    public ResponseEntity<?>getAllStudents(){
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudents());
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object>updateStudent(@PathVariable Integer studentId, @RequestBody UpdateStudentDto updateStudentDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(studentId,updateStudentDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Object>deleteStudent(@PathVariable Integer studentId){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(studentId));
    }

    @DeleteMapping("")
    public ResponseEntity<String>deleteAllStudents(){
        studentService.deleteAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body("All rows deleted successfully");
    }
}
