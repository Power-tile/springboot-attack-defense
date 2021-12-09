package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.model.CommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentAddVO {
  private Integer postId;
  private String content;
  private Date time;

  public CommentAddVO(CommentDTO commentDTO) {
    this.postId = commentDTO.getPostId();
    this.content = commentDTO.getContent();
    this.time = commentDTO.getTime();
  }
}
