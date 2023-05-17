package com.codeline.sampleProject.requestobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetEmployeeRequest {
    String name;
    String department;
    String gender;
}
