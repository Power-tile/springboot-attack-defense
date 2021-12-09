package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import edu.illinois.springbootattackdefense.model.PostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostAddVO {
  private Integer userId;
  private String content;
  private Date time;
}
