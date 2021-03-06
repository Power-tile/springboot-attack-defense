package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.model.PostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostViewVO {
  private Integer id;
  private String name;
  private String content;
  private Date time;

  public PostViewVO(PostDTO postDTO, UserViewVO userDTO) {
    this.id = postDTO.getId();
    this.name = userDTO.getName();
    this.content = postDTO.getContent();
    this.time = postDTO.getTime();
  }
}
