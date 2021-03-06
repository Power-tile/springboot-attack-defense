package edu.illinois.springbootattackdefense.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostAddVO {
  private Integer userId;
  private String content;
  private Date time;
}
