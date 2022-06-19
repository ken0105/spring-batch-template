package com.ken0105.springbatchtemplate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private String genderString;

    public Employee convertGenderStringToInt() {
        if("男性".equals(genderString)) {
            this.gender = 1;
            return new Employee(this.id, this.name, this.age, 1, this.genderString);
        } else if ("女性".equals(genderString)) {
            return new Employee(this.id, this.name, this.age, 2, this.genderString);
        } else {
            return new Employee(this.id, this.name, this.age, 3, this.genderString);
        }
    }
}
