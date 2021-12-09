package edu.illinois.springbootattackdefense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.illinois.springbootattackdefense.model.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, Integer> {
  
}
