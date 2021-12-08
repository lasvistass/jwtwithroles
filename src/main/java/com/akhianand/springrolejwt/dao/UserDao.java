package com.akhianand.springrolejwt.dao;

import com.akhianand.springrolejwt.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    
    @Query(value = " INSERT INTO user_roles (user_id, role_id) VALUES ( ?1, 1)", nativeQuery = true)
    void setAdminToUser(Long id);
    
}