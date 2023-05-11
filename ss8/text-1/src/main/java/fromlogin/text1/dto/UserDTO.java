package fromlogin.text1.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {
    private int id;
    @NotNull
    @Size(min = 5, max = 45)
    @NotBlank
    private String firstName;
    @NotNull
    @Size(min = 5, max = 45)
    @NotBlank
    private String lastName;
    @NumberFormat
    private int phoneNumber;
    @NotNull
    @DateTimeFormat(pattern = ("dd-MM-yyyy"))
    private String dateOfBirth;

    @NotBlank
    @Email
    @Pattern(regexp = "^([\\w]*[\\w\\.]*(?!\\.)@gmail.com)")
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, int phoneNumber, String dateOfBirth, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Login login = (Login) target;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//        String date = login.getDateOfBirth();
//        //convert String to LocalDate
////        LocalDate localDate = LocalDate.parse(date, formatter);
//        LocalDate localDate = LocalDate.now();
//        if (18 > (localDate - date))
    }
}
