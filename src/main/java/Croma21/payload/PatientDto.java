package Croma21.payload;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PatientDto {

    private Long patientId;

    @Size(min = 2, max = 20, message = "character should be more than 2 character")
    private String name;

    @NotNull(message = "Age is required")
    private Integer age;

    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @Size(min = 10, max = 50, message = "Address should be 10 character")
    private String address;

    @Size(min = 10, max = 10, message = " should be 10 digit")
    private String phone;

    @Email(message = "invalid email")
    private String email;
}
