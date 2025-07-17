package org.umar.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umar.learning.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
