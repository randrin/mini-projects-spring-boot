package com.randrin.request.validation.exception.dto;

import com.randrin.request.validation.exception.constants.UserValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = UserValidationConstants.USER_NAME_REQUIRED)
    private String name;

    @Email(message = UserValidationConstants.USER_EMAIL_REQUIRED)
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = UserValidationConstants.USER_MOBILE_REQUIRED)
    private String mobile;

    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
