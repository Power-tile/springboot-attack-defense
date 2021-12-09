package edu.illinois.springbootattackdefense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.illinois.springbootattackdefense.vo.UserAddVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserDTO {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private Integer role;

  public UserDTO(UserAddVO userAddVO) {
    this.name = userAddVO.getName();
    this.password = userAddVO.getPassword();
    this.role = userAddVO.getRole();
  }
}
