package com.randrin.request.validation.exception.repository;

import com.randrin.request.validation.exception.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserId(String userId);

    User findByEmail(String email);

    User findByMobile(String mobile);

    User findByName(String name);
}
