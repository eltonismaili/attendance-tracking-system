//package com.example.attendancetrackingsystem.controllers;
//
//import com.example.attendancetrackingsystem.dto.LoginRequesDto;
//import com.example.attendancetrackingsystem.dto.UserDto;
//import com.example.attendancetrackingsystem.dto.UserRegistrationDto;
//import com.example.attendancetrackingsystem.exceptions.EmailExistException;
//import com.example.attendancetrackingsystem.exceptions.UserNotFoundException;
//import com.example.attendancetrackingsystem.exceptions.UsernameExistException;
//import com.example.attendancetrackingsystem.exceptions.WrongPasswordException;
//import com.example.attendancetrackingsystem.service.UserService;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//@Controller
//public class AuthController {
//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("loginRequestDto", new LoginRequesDto());
//        return "auth/login";
//    }
//
//    @PostMapping("/login")
//    public String login(
//            @Valid @ModelAttribute LoginRequesDto loginRequestDto
//            , BindingResult bindingResult
//            , HttpServletRequest request
//            , HttpServletResponse response
//            , @RequestParam(value = "returnUrl", required = false) String returnUrl
//    ) {
//        if (bindingResult.hasErrors()) {
//            return "auth/login";
//        }
//
//        try {
//            var userDto = userService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
//
//
//            HttpSession session = request.getSession(); // krijo nje session te ri
//            session.setAttribute("user", userDto);
//            session.setAttribute("grupi", "2");
////        session.setAttribute("items", "laptop lenovo x carbon");
//
//
//            Cookie cookie = new Cookie("userId", String.valueOf(userDto.getId()));
//            if (loginRequestDto.isRememberMe())
//                cookie.setMaxAge(60 * 60 * 24); // 1 day cookie
//            else
//                cookie.setMaxAge(60 * 60); //1 hour
//            response.addCookie(cookie);
//
//            if (returnUrl != null && !returnUrl.isBlank())
//                return "redirect:" + returnUrl;
//
//            return "redirect:/";
//        } catch (UserNotFoundException e) {
//            bindingResult.rejectValue("username", "error.loginRequestDto",
//                    "Username not found!");
//            return "auth/login";
//        } catch (WrongPasswordException e) {
//            bindingResult.rejectValue("password", "error.loginRequestDto",
//                    "Wrong password!");
//            return "auth/login";
//        }
//
//    }
//
//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("userRequestRegistrationDto", new UserRegistrationDto());
//        return "auth/register";
//    }
//
//
//    @PostMapping("/register")
//    public String register(@Valid @ModelAttribute UserRegistrationDto userRequestRegistrationDto,
//                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "auth/register";
//        }
//
//        if (!userRequestRegistrationDto.getPassword().equals(userRequestRegistrationDto.getConfirmPassword())) {
//            bindingResult.rejectValue("confirmPassword", "error.userRequestRegistrationDto",
//                    "Password and Confirm Password do not match!");
//            return "auth/register";
//        }
//
//        try {
//            UserDto userDto = userService.register(userRequestRegistrationDto);
//            redirectAttributes.addFlashAttribute("message", "User registered successfully!");
//            // mundemi me ruajt sessionin qe eshte logu
//
//        } catch (UsernameExistException e) {
//            bindingResult.rejectValue("username", "error.userRequestRegistrationDto",
//                    "Username already exists!");
//            return "auth/register";
//        } catch (EmailExistException e) {
//            bindingResult.rejectValue("email", "error.userRequestRegistrationDto",
//                    "Email already exists!");
//            return "auth/register";
//        }
//
//
//        //service per registrim
//
//        return "redirect:/login";
//    }
//
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        // make cookie expire / invalid
//        Cookie cookie = new Cookie("userId", "");
//        cookie.setMaxAge(0); // 0 seconds available
//        response.addCookie(cookie);
//
//        HttpSession session = request.getSession(false);
//        session.invalidate();
//        return "redirect:/login";
//    }
//}
