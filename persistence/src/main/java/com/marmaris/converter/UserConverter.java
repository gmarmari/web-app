package com.marmaris.converter;

import com.marmaris.dao.UserDao;
import com.marmaris.dto.UserDto;
import com.marmaris.dto.UserDtoBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDao toDao(UserDto dto) {
        UserDao dao = new UserDao();
        dao.setId(dto.getId());
        dao.setVersion(dto.getVersion());
        dao.setName(dto.getName());
        dao.setRole(dto.getRole());
        return dao;
    }

    public UserDto toDto(UserDao dao) {
        return new UserDtoBuilder()
                .withId(dao.getId())
                .withVersion(dao.getVersion())
                .withName(dao.getName())
                .withRole(dao.getRole())
                .build();
    }

}
