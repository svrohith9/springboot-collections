package com.crudapp.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.crudapp.beans.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByName(String name);

}
