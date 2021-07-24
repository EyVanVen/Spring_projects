package com.app.dao.repositories;


import com.app.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> getUsersByLogin(String login);

    List<User> getUserByEmail(String email);

    List<User> getUserById(Long id);
}