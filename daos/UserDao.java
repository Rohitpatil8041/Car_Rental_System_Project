package com.ecity.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecity.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	List<User> findByRole(String role);
	Optional<User> findByResetToken(String resetToken);

}
