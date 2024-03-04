package com.kunal.CRUD_Operations.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDto {

    private String name;
    private Integer age;
    private String grade;

}
