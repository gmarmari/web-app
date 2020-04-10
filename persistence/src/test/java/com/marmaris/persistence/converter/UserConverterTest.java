package com.marmaris.persistence.converter;

import com.marmaris.persistence.dao.UserDao;
import com.marmaris.common.dto.UserDto;
import com.marmaris.common.dto.UserDtoBuilder;
import com.marmaris.common.enums.Role;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserConverterTest {

    private static final Long ID = 123L;
    private static final Integer VERSION = 3;
    private static final String NAME = "Mickey";
    private static final Role ROLE = Role.USER;

    private final UserConverter converter = new UserConverter();

    @Test
    void toDto() {
        // Given
        UserDao dao = new UserDao();
        dao.setId(ID);
        dao.setVersion(VERSION);
        dao.setName(NAME);
        dao.setRole(ROLE);

        // When
        UserDto dto = converter.toDto(dao);

        // Then
        assertThat(dto.getId()).isEqualTo(ID);
        assertThat(dto.getVersion()).isEqualTo(VERSION);
        assertThat(dto.getName()).isEqualTo(NAME);
        assertThat(dto.getRole()).isEqualTo(ROLE);
    }

    @Test
    void toDao() {
        // Given
        UserDto dto = new UserDtoBuilder()
                .withId(ID)
                .withVersion(VERSION)
                .withName(NAME)
                .withRole(ROLE)
                .build();

        // When
        UserDao dao = converter.toDao(dto);

        // Then
        assertThat(dao.getId()).isEqualTo(ID);
        assertThat(dao.getVersion()).isEqualTo(VERSION);
        assertThat(dao.getName()).isEqualTo(NAME);
        assertThat(dao.getRole()).isEqualTo(ROLE);
    }

}