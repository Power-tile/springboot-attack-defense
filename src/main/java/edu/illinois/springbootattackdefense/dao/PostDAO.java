package edu.illinois.springbootattackdefense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.illinois.springbootattackdefense.model.PostDTO;

@Repository
public interface PostDAO extends JpaRepository<PostDTO, Integer> {
  
}
