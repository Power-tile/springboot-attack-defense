package edu.illinois.springbootattackdefense.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAddVO {
  private String name;
  private String password;
  private Integer role;
}
