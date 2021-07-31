package com.app.bootApp.dao.repositories;


import com.app.bootApp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {


    List<User> getUsersByLogin(String login);

    List<User> getUserByEmail(String email);

    Optional<User> getUserById(Long id);
}