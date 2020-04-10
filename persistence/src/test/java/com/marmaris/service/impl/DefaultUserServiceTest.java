package com.marmaris.service.impl;


import com.marmaris.converter.UserConverter;
import com.marmaris.dao.UserDao;
import com.marmaris.dto.UserDto;
import com.marmaris.dto.UserDtoBuilder;
import com.marmaris.enums.Role;
import com.marmaris.repository.UserRepository;
import com.marmaris.service.UserService;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DefaultUserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserConverter userConverter = mock(UserConverter.class);
    private final UserService service = new DefaultUserService(userRepository, userConverter);

    @Test
    void findById() {
        // Given
        long id = 1L;
        String name = "Mickey";
        Role role = Role.ADMIN;

        UserDao dao = buildDao(id, name, role);
        UserDto dto = buildDto(id, name, role);

        when(userRepository.findById(id)).thenReturn(Optional.of(dao));
        when(userConverter.toDto(dao)).thenReturn(dto);

        // When
        UserDto result = service.findById(id);

        // Then
        assertThat(result).isEqualTo(dto);

        // Verify
        verify(userRepository).findById(id);
        verifyNoMoreInteractions(userRepository);

        verify(userConverter).toDto(dao);
        verifyNoMoreInteractions(userConverter);
    }

    @Test
    void findByIdNotFound() {
        // Given
        long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // When
        // Then
        assertThrows(EntityNotFoundException.class, ()-> service.findById(id));

        // Verify
        verify(userRepository).findById(id);
        verifyNoMoreInteractions(userRepository);

        verifyNoInteractions(userConverter);
    }



    private UserDao buildDao(long id, String name, Role role) {
        UserDao dao = new UserDao();
        dao.setId(id);
        dao.setVersion(0);
        dao.setName(name);
        dao.setRole(role);
        return dao;
    }

    private UserDto buildDto(long id, String name, Role role) {
        return new UserDtoBuilder()
                .withId(id)
                .withVersion(0)
                .withName(name)
                .withRole(role)
                .build();
    }

}