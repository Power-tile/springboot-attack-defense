package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.model.PostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVO {
  private Integer id;
  private Integer userId;
  private String content;
  private Date time;

  public PostVO(PostDTO postDTO) {
    this.id = postDTO.getId();
    this.userId = postDTO.getUserId();
    this.content = postDTO.getContent();
    this.time = postDTO.getTime();
  }
}
