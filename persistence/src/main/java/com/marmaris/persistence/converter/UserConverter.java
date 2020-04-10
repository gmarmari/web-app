package com.marmaris.persistence.converter;

import com.marmaris.persistence.dao.UserDao;
import com.marmaris.common.dto.UserDto;
import com.marmaris.common.dto.UserDtoBuilder;
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
