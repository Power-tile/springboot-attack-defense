package edu.illinois.springbootattackdefense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.illinois.springbootattackdefense.vo.PostAddVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class PostDTO {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "content")
  private String content;

  @Column(name = "time")
  private Date time;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "status")
  private Integer status;

  public PostDTO(PostAddVO postAddVO, Integer userId) {
    this.content = postAddVO.getContent();
    this.time = new Date();
    this.status = 0;
    this.userId = userId;
  }
}
