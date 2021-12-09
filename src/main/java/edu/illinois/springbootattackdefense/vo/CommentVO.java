package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.model.CommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
  private Integer id;
  private Integer userId;
  private Integer postId;
  private String content;
  private Date time;

  public CommentVO(CommentDTO commentDTO) {
    this.id = commentDTO.getId();
    this.userId = commentDTO.getUserId();
    this.postId = commentDTO.getPostId();
    this.content = commentDTO.getContent();
    this.time = commentDTO.getTime();
  }
}
