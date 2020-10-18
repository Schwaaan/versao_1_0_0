package com.teste.teste.repository;

import com.teste.teste.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByLoginAndPasswordAndDeletedIsFalse(String login, String password);

}