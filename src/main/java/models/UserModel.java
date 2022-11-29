package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public UserModel(String[] valuesFromPage) {
        this.firstName = valuesFromPage[0];
        this.lastName = valuesFromPage[1];
        this.age = valuesFromPage[2];
        this.email = valuesFromPage[3];
        this.salary = valuesFromPage[4];
        this.department = valuesFromPage[5];
    }
}
