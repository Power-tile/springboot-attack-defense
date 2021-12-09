package edu.illinois.springbootattackdefense.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.illinois.springbootattackdefense.dao.UserDAO;
import edu.illinois.springbootattackdefense.model.UserDTO;
import edu.illinois.springbootattackdefense.service.PrivilegeService;
import edu.illinois.springbootattackdefense.vo.LoginVO;
import edu.illinois.springbootattackdefense.vo.UserAddVO;
import edu.illinois.springbootattackdefense.vo.UserViewVO;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserDAO userDAO;

  @Autowired
  PrivilegeService privilegeService;

  @PostMapping("/login")
  public void login(@RequestBody LoginVO loginVO, HttpSession session, HttpServletResponse response) throws IOException {
    List<UserDTO> users = userDAO.findAllByNameAndPassword(loginVO.getName(), loginVO.getPassword());
    if (users.isEmpty()) {
      response.setStatus(401);
      response.getWriter().append("401");
      return;
    }

    session.setAttribute("user_id", users.get(0).getId());
  }

  @RequestMapping("/logout")
  public void logout(HttpSession session) {
    session.setAttribute("user_id", -1);
  }

  @RequestMapping("/info/{id}")
  public UserViewVO getUserInfo(@PathVariable(name = "id") Integer id) {
    UserDTO user = userDAO.getById(id);
    if (user == null) return new UserViewVO();
    return new UserViewVO(user);
  }

  @PostMapping("/add")
  public void addUser(@RequestBody UserAddVO userAddVO, HttpSession session, HttpServletResponse response) throws IOException {
    if (!privilegeService.validatePrivilege(session, 2)) {
      response.setStatus(401);
      response.getWriter().append("401");
      return;
    }
    userDAO.save(new UserDTO(userAddVO));
  }
}
