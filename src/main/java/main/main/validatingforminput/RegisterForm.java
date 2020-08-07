package main.main.validatingforminput;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {
    @Size(min=2, max=30)
    private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "Minimum eight characters, at least one letter, one number and one special character")
    private String password;
    @Size(min=2, max=30)
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$"
            , message = "year format is DD/MM/YYYY")
    private String brithDate;
    @Size(min=2, max=30)
    @Pattern(regexp = "^[a-zA-Z]+", message = "Not Numbers Allow")
    private String firstName;
    @Size(min=2, max=30)
    @Pattern(regexp = "^[a-zA-Z]+", message = "Not Numbers Allow")
    private String surname;
    @AssertTrue
    private Boolean check;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}
