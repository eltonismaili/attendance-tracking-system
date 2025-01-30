//package com.example.attendancetrackingsystem.dto;
//
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//
//public class LoginRequesDto {
//    @NotBlank(message = "Username nuk lejon vlera boshe")
//    @NotNull(message = "Username nuk lejon vlera null")
//    @Size(min = 3, max = 50, message = "Username duhet te jete midis 3 dhe 50 karaktere")
//    private String username;
//
//    @NotBlank(message = "Password nuk lejon vlera boshe")
//    @NotNull(message = "Password nuk lejon vlera null")
//    @Size(min = 6, max = 100, message = "Passwordi duhet te jete midis 6 dhe 100 karaktere")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
//            message = "Passwordi duhet te permbaje se paku nje shkronje te madhe, nje shkronje te vogel dhe nje numer")
//    private String password;
//
//    private boolean rememberMe;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
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
//    public boolean isRememberMe() {
//        return rememberMe;
//    }
//
//    public void setRememberMe(boolean rememberMe) {
//        this.rememberMe = rememberMe;
//    }
//}
