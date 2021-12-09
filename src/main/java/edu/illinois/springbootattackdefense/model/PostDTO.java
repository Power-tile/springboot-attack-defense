package edu.illinois.springbootattackdefense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
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
}
