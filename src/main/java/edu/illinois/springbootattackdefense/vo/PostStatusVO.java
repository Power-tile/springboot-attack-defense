package edu.illinois.springbootattackdefense.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostStatusVO {
  private Integer postId;
  private Integer newStatus;
}
