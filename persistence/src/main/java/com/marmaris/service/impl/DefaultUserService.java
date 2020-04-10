package com.marmaris.service.impl;

import com.marmaris.converter.UserConverter;
import com.marmaris.dto.UserDto;
import com.marmaris.repository.UserRepository;
import com.marmaris.service.UserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public DefaultUserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userConverter::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Could not find a User with ID: " + id));
    }

}
