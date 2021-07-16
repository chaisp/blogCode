package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.po.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return new UserDto(user.get());
        } else {
            throw new RuntimeException("user not exist");
        }
    }
}
