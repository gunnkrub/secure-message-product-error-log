package ku.message.dto;

import ku.message.validation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignupDto {

    @NotBlank
    @Size(min=4, message = "Username must be 4 characters long")
    private String username;

    @NotBlank
    @ValidPassword
    private String password;

    @NotBlank(message = "Firstname must not be blank")
    @Pattern(regexp = "^[a-zA-Z]+$",
            message = "First name can only contain letters")
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String role;
}
