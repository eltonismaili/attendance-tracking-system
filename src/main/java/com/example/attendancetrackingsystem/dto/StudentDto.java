package com.example.attendancetrackingsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @PositiveOrZero(message = "Id should be a positive number")
    private Long id;
    @NotNull(message = "First name should not be null")
    @NotBlank(message = "First name should not be blank")
    @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters")
    private String firstName;
    @NotNull(message = "Last name should not be null")
    @NotBlank(message = "Last name should not be blank")
    @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters")
    private String lastName;
    @NotNull(message = "Email should not be null")
    @Size(max = 100, message = "Email should be at most 100 characters")
    @Email(message = "Email should be valid")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
