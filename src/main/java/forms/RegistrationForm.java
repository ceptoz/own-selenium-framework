package forms;

import forms.base.BaseForm;
import forms.base.Button;
import forms.base.TextBox;
import models.UserModel;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
    By firstNameLocator = By.id("firstName");
    TextBox firstName = new TextBox(firstNameLocator, "First name field");
    By lastNameLocator = By.id("lastName");
    TextBox lastName = new TextBox(lastNameLocator, "Last name field");
    By emailLocator = By.id("userEmail");
    TextBox email = new TextBox(emailLocator, "Email field");
    By ageLocator = By.id("age");
    TextBox age = new TextBox(ageLocator, "Age field");
    By salaryLocator = By.id("salary");
    TextBox salary = new TextBox(salaryLocator, "Salary field");
    By departmentLocator = By.id("department");
    TextBox department = new TextBox(departmentLocator, "Department field");
    By submitLocator = By.xpath("//button[@id='submit']");
    Button submit = new Button(submitLocator, "Submit data button");

    public RegistrationForm() {
        super(By.xpath("//div[@id='registration-form-modal']"), "Registration form");
    }

    public void fillTheRegistrationField(UserModel user) {
        firstName.typeText(user.getFirstName());
        lastName.typeText(user.getLastName());
        email.typeText(user.getEmail());
        age.typeText(user.getAge());
        salary.typeText(user.getSalary());
        department.typeText(user.getDepartment());
    }

    public void clickSubmitBtn() {
        submit.click();
    }
}
