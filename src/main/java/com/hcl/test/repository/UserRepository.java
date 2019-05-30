package com.hcl.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.test.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
