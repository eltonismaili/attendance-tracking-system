//package com.example.attendancetrackingsystem.service.impls;
//
//
//import com.example.attendancetrackingsystem.dto.UserDto;
//import com.example.attendancetrackingsystem.dto.UserListDto;
//import com.example.attendancetrackingsystem.dto.UserRegistrationDto;
//import com.example.attendancetrackingsystem.exceptions.EmailExistException;
//import com.example.attendancetrackingsystem.exceptions.UserNotFoundException;
//import com.example.attendancetrackingsystem.exceptions.UsernameExistException;
//import com.example.attendancetrackingsystem.exceptions.WrongPasswordException;
//import com.example.attendancetrackingsystem.mappers.UserMapper;
//import com.example.attendancetrackingsystem.models.User;
//import com.example.attendancetrackingsystem.repositories.UserRepository;
//import com.example.attendancetrackingsystem.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository repository;
//    private final UserMapper mapper;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder) {
//        this.repository = repository;
//        this.mapper = mapper;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDto findById(Long id) {
//        var user = repository.findById(id).orElse(null);
//        if (user == null) {
//            System.out.println("User not found!");
//            return null;
//        }
//
//        return mapper.toDto(user);
//    }
//
//    @Override
//    public UserDto login(String username, String password) {
//        Optional<User> optionalUser = repository.findByUsername(username);
//
//        if (optionalUser.isEmpty()) {
//            throw new UserNotFoundException();
//        }
//
//        User user = optionalUser.get();
//
//
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new WrongPasswordException();
//        }
////        if (!user.getPassword().equals(password)) {
////            System.out.println("Password is incorrect");
////            return null;
////        }
//
////        UserDto userDto = new UserDto();
////        userDto.setId(user.getId());
////        userDto.setName(user.getName());
////        userDto.setSurname(user.getSurname());
////        userDto.setUsername(user.getUsername());
////        userDto.setEmail(user.getEmail());
////        userDto.setImageUrl(user.getImageUrl());
////        userDto.setInterests(user.getInterests());
////        userDto.setBirthdate(user.getBirthdate());
////        userDto.setAddress(user.getAddress());
////        userDto.setCity(user.getCity());
////        userDto.setCountry(user.getCountry());
////        userDto.setPostalCode(user.getPostalCode());
////        userDto.setGender(user.getGender());
//        // return userDto;
//
//
//        return mapper.toDto(user);
//    }
//
//    @Override
//    public List<UserListDto> getUserListing() {
//        var users = repository.findAll();
//        return users.stream().map(mapper::toUserListDto).toList(); // direct  method referencing
//        //return users.stream().map(u->mapper.toUserListDto(u)).toList();// lambda expression
//
////        return users.stream().map(new Function<User, UserListDto>() {
////            @Override
////            public UserListDto apply(User user) {
////                return mapper.toUserListDto(user);
////            }
////        }).toList();  //anonymous inner class
//    }
//
//    @Override
//    public UserDto register(UserRegistrationDto userRequestRegistrationDto) {
//
//        if (repository.findByUsername(userRequestRegistrationDto.getUsername()).isPresent()) {
//            throw new UsernameExistException();
//        }
//
//        if (repository.findByEmail(userRequestRegistrationDto.getEmail()).isPresent()) {
//            throw new EmailExistException();
//        }
//
//        User user = mapper.userRequestRegistrationDtoToUser(userRequestRegistrationDto);
//        user.setPassword(passwordEncoder.encode(userRequestRegistrationDto.getPassword()));
//
//        User savedUser = repository.save(user);
//
//        return mapper.toDto(savedUser);
//    }
//}