package com.marmaris.service;

import com.marmaris.dto.UserDto;

public interface UserService {

    /**
     * @param id    the ID of a User
     * @return the User for the given ID
     * @throws javax.persistence.EntityNotFoundException if no User exists for the given ID
     */
    UserDto findById(Long id);

}
