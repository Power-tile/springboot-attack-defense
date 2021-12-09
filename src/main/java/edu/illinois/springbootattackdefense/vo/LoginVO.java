package edu.illinois.springbootattackdefense.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginVO {
  private String name;
  private String password;
}
