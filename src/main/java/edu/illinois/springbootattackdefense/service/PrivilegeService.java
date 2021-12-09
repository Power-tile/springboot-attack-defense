package edu.illinois.springbootattackdefense.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.illinois.springbootattackdefense.dao.UserDAO;
import edu.illinois.springbootattackdefense.model.UserDTO;

@Resource
public class PrivilegeService {
  @Autowired
  UserDAO userDAO;

  public Integer getUserId(HttpSession session) {
    return (Integer)session.getAttribute("user_id");
  }

  public Integer getRole(HttpSession session) {
    Integer userId = (Integer)session.getAttribute("user_id");
    UserDTO user = userDAO.getById(userId);
    return user == null ? null : user.getRole();
  }

  public boolean validatePrivilege(HttpSession session, Integer requiredRole) {
    Integer role = this.getRole(session);
    if (role == null) return false;
    return requiredRole <= role;
  }
}
