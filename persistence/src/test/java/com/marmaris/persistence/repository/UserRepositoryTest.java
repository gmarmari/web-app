package com.marmaris.persistence.repository;

import com.marmaris.persistence.config.DatabaseConfiguration;
import com.marmaris.persistence.dao.UserDao;
import com.marmaris.persistence.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ContextConfiguration(classes = DatabaseConfiguration.class)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    void findById() {
        // Given
        UserDao dao = new UserDao();
        dao.setName("Mickey");
        dao.setRole(Role.USER);

        Long id = entityManager.persistAndGetId(dao, Long.class);

        // when
        Optional<UserDao> optionalUserDao = repository.findById(id);

        // Then
        assertThat(optionalUserDao).isPresent();
        UserDao result = optionalUserDao.get();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getName()).isEqualTo(dao.getName());
        assertThat(result.getRole()).isEqualTo(dao.getRole());
    }

}