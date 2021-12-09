package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.dao.CommentDAO;
import edu.illinois.springbootattackdefense.model.CommentDTO;
import edu.illinois.springbootattackdefense.model.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentViewVO {
  private Integer id;
  private String name;
  private String content;
  private Date time;

  public CommentViewVO(CommentDTO commentDTO, UserDTO userDTO) {
    this.id = commentDTO.getId();
    this.name = userDTO.getName();
    this.content = commentDTO.getContent();
    this.time = commentDTO.getTime();
  }
}
