package com.example.loginapp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
  @Autowired
    private UserRepository repo;
  @Autowired
    private TestEntityManager entityManager;

  @Test
    public void testCreateUser(){
      User user= new User();
      user.setEmail("Rashidomar@gmail.com");
      user.setFirstname("Rashid");
      user.setLastname("omar");
      user.setPassword("omar1234");

      User savedUser = repo.save(user);

      User existUser = entityManager.find(User.class, savedUser.getId());
      Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

  }


}
