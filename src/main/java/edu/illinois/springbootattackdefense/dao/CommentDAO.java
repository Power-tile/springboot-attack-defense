package edu.illinois.springbootattackdefense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.illinois.springbootattackdefense.model.CommentDTO;

@Repository
public interface CommentDAO extends JpaRepository<CommentDTO, Integer> {
  public List<CommentDTO> findAllByPostId(Integer postId);
}
