package com.kunal.CRUD_Operations.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddStudentDto {

    private String name;
    private Integer age;
    private String grade;

}
