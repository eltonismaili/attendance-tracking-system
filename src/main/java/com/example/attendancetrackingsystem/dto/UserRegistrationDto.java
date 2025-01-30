//package com.example.attendancetrackingsystem.dto;
//
//import com.example.attendancetrackingsystem.infrastructure.AgeBetween;
//import com.example.attendancetrackingsystem.infrastructure.NotEquals;
//import jakarta.validation.constraints.*;
//
//import java.time.LocalDate;
//
//public class UserRegistrationDto {
//    @NotBlank(message = "Name is required")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
//    private String name;
//
//    private String surname;
//
//    private String username;
//
//    @Email(message = "Email is not valid")
//    private String email;
//
//    @Past(message = "Birthdate must be in the past")
//    //@AtLeast18YearsOld(message = "You must be at least 18 years old")
////    @MinAge(value = 18, message = "You must be at least 18 years old")
//    @AgeBetween(min=18, max=64, message = "You must be between 18 and 64 years old")
//    private   String birthdate;
//
//    //@Not(value="Serbia", message = "You must not be from Serbia")
//    //@NotEqual(value = "Serbia", message = "You must not be from Serbia")
//    @NotEquals(value = "Serbia", message = "You must not be from Serbia")
//    private String country;
//
//    @NotBlank(message = "Password is required")
//    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one uppercase letter, one lowercase letter and one number")
//    private String password;
//
//    @NotBlank(message = "Password is required")
//    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one uppercase letter, one lowercase letter and one number")
//    //@SameAs(field="password", message = "Passwords must match")
//    private String confirmPassword;
//
//    @AssertTrue(message = "You must accept the terms and conditions")
//    private boolean acceptTerms;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(String birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public boolean isAcceptTerms() {
//        return acceptTerms;
//    }
//
//    public void setAcceptTerms(boolean acceptTerms) {
//        this.acceptTerms = acceptTerms;
//    }
//}
