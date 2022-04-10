package com.randrin.request.validation.exception.service;

import com.randrin.request.validation.exception.constants.UserValidationConstants;
import com.randrin.request.validation.exception.dto.UserRequest;
import com.randrin.request.validation.exception.entity.User;
import com.randrin.request.validation.exception.exception.UserFoundException;
import com.randrin.request.validation.exception.exception.UserNotFoundException;
import com.randrin.request.validation.exception.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserRequest userRequest) {
        User user = User.build(
                "",
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());
        User userEmail = userRepository.findByEmail(userRequest.getEmail());
        if (userEmail == null) {
            User userPhone = userRepository.findByMobile(userRequest.getMobile());
            if (userPhone == null) {
                User userName = userRepository.findByName(userRequest.getName());
                if (userName == null) {
                    return userRepository.save(user);
                } else {
                    throw new UserFoundException(UserValidationConstants.USER_EXIST_WITH_NAME + userRequest.getName());
                }
            } else {
                throw new UserFoundException(UserValidationConstants.USER_EXIST_WITH_MOBILE + userRequest.getMobile());
            }
        } else {
            throw new UserFoundException(UserValidationConstants.USER_EXIST_WITH_EMAIL + userRequest.getEmail());
        }
    }

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String userId) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            return userRepository.findByUserId(userId);
        } else {
            throw new UserNotFoundException(UserValidationConstants.USER_NOT_FOUND_WITH_ID + userId);
        }
    }
}
