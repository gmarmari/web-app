package com.marmaris.persistence.service.impl;

import com.marmaris.persistence.converter.UserConverter;
import com.marmaris.common.dto.UserDto;
import com.marmaris.persistence.repository.UserRepository;
import com.marmaris.persistence.service.UserService;
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
