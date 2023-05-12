package fromlogin.text1.dto;

import fromlogin.text1.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")
    private String phoneNumber;

//    @Pattern(regexp = "^\\d{1,2}-\\d{1,2}-\\d{4}$")
    @NotNull
    private String dateOfBirth;

    @NotBlank
    @Email
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, String dateOfBirth, String email) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        UserDTO userDTO = (UserDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        String date = userDTO.getDateOfBirth();

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
       int yearBirth= localDate.getYear();

        if ((year-yearBirth)<18){
            errors.rejectValue("dateOfBirth", "dateOfBirth","phai lon hon 18");
        }
    }
}
