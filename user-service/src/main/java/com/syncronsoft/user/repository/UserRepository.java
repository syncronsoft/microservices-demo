package com.syncronsoft.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syncronsoft.user.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUserId(Long userId);

}
