package com.test.kubity.dao;

import com.test.kubity.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataBase extends JpaRepository<User, Integer> {
}
