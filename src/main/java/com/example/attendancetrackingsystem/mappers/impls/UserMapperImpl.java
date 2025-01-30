//package com.example.attendancetrackingsystem.mappers.impls;
//
//import com.example.attendancetrackingsystem.dto.UserDto;
//import com.example.attendancetrackingsystem.dto.UserListDto;
//import com.example.attendancetrackingsystem.dto.UserRegistrationDto;
//import com.example.attendancetrackingsystem.mappers.UserMapper;
//import com.example.attendancetrackingsystem.models.User;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public UserDto toDto(User user) {
//        UserDto userDto = new UserDto();
//
//        userDto.setName(user.getName());
//        userDto.setSurname(user.getSurname());
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        userDto.setBirthdate(user.getBirthdate());
//        userDto.setCountry(user.getCountry());
//        return userDto;
//    }
//
//    @Override
//    public User toEntity(UserDto userDto) {
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setSurname(userDto.getSurname());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setBirthdate(userDto.getBirthdate());
//        user.setCountry(userDto.getCountry());
//        return user;
//    }
//
//    @Override
//    public User userRequestRegistrationDtoToUser(UserRegistrationDto userRequestRegistrationDto) {
//        User user = new User();
//        user.setName(userRequestRegistrationDto.getName());
//        user.setSurname(userRequestRegistrationDto.getSurname());
//        user.setUsername(userRequestRegistrationDto.getUsername());
//        user.setEmail(userRequestRegistrationDto.getEmail());
//        user.setBirthdate(userRequestRegistrationDto.getBirthdate());
//        user.setCountry(userRequestRegistrationDto.getCountry());
//        return user;
//    }
//
//    @Override
//    public UserListDto toUserListDto(User user) {
//        UserListDto uld = new UserListDto();
//        uld.setId(user.getId());
//        uld.setName(user.getName());
//        uld.setSurname(user.getSurname());
//        uld.setUsername(user.getUsername());
//        uld.setEmail(user.getEmail());
//        return uld;
//    }
//}
