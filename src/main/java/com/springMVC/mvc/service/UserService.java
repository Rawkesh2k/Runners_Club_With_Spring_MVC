package com.springMVC.mvc.service;

import com.springMVC.mvc.dto.RegistrationDTO;
import com.springMVC.mvc.models.UserEntity;
import com.springMVC.mvc.repository.UserRepository;

public interface UserService {

    void saveUser(RegistrationDTO registrationDTO);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
