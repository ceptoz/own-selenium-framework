package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String number;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
}
