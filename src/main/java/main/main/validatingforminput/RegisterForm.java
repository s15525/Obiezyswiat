package main.main.validatingforminput;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
    @NotNull
    @Size(min=2, max=30)
    private String email;
    @NotNull
    @Size(min=2, max=30)
    private String password;
    @NotNull
    @Size(min=2, max=30)
    private String brithDate;
    @NotNull
    @Size(min=2, max=30)
    private String firstName;
    @NotNull
    @Size(min=2, max=30)
    private String Surname;

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

    public String getbrithDate() {
        return brithDate;
    }

    public void setbrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
