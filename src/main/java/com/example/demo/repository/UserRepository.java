package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserEmail(String email);

	User findByUserId(Long userId);
	
//	@Query(value = "SELECT * FROM user WHERE user.user_email = ?1", nativeQuery = true)
//		User updateDetails(User user);
	
}
