package com.marmaris.persistence.repository;

import com.marmaris.persistence.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao, Long> {
}
