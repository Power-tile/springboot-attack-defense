package edu.illinois.springbootattackdefense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.illinois.springbootattackdefense.model.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, Integer> {
  List<UserDTO> findAllByNameAndPassword(String name, String password);
}
