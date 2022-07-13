package com.lab.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab.crud.entities.Users;



public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query("Select o from Users o where o.gmail = ?1 and o.pass=?2")
	Users findByEmailnPassword(String email, String password);
	@Query("Select o from Users o where o.gmail = ?1")
	Users findByEmail(String email);
}
