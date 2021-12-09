package edu.illinois.springbootattackdefense.vo;

import edu.illinois.springbootattackdefense.model.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {
  private Integer id;
  private String name;
  private Integer role;

  public UserVO(UserDTO userDTO) {
    this.id = userDTO.getId();
    this.name = userDTO.getName();
    this.role = userDTO.getRole();
  }
}
