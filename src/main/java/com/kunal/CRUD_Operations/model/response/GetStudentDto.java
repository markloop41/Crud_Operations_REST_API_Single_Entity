package com.kunal.CRUD_Operations.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStudentDto {

    private Integer id;
    private String name;
    private Integer age;
    private String grade;

}
