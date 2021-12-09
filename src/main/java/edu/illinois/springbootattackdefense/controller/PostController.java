package edu.illinois.springbootattackdefense.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.illinois.springbootattackdefense.dao.PostDAO;
import edu.illinois.springbootattackdefense.model.PostDTO;
import edu.illinois.springbootattackdefense.service.PrivilegeService;
import edu.illinois.springbootattackdefense.vo.PostAddVO;
import edu.illinois.springbootattackdefense.vo.PostViewVO;

@RestController
@RequestMapping(name = "/api/post")
public class PostController {
  @Autowired
  PostDAO postDAO;

  @Autowired
  UserController userController;

  @Autowired
  PrivilegeService privilegeService;

  @RequestMapping("/get/")
  List<PostViewVO> getAllPosts() {
    List<PostDTO> posts = postDAO.findAll();
    ArrayList<PostViewVO> ret = new ArrayList<PostViewVO>();
    for (PostDTO post : posts) {
      ret.add(new PostViewVO(post, userController.getUserInfo(post.getUserId())));
    }
    return ret;
  }

  @RequestMapping("/get/{id}")
  PostViewVO getPost(@PathVariable(name = "id") Integer id) {
    PostDTO post = postDAO.getById(id);
    return new PostViewVO(post, userController.getUserInfo(post.getUserId()));
  }

  @PostMapping("/add")
  void addPost(@RequestBody PostAddVO postAddVO, HttpSession session, HttpServletResponse response) throws IOException {
    if (!privilegeService.validatePrivilege(session, 1)) {
      response.setStatus(401);
      response.getWriter().append("401");
      return;
    }

    postDAO.save(new PostDTO(postAddVO, (Integer)session.getAttribute("user_id")));
  }

  @RequestMapping("/delete/{id}")
  void deletePost(@PathVariable(name = "id") Integer id, HttpSession session, HttpServletResponse response) throws IOException {
    PostDTO post = postDAO.getById(id);
    if (privilegeService.validatePrivilege(session, 2) || (privilegeService.validatePrivilege(session, 1) && post.getUserId() == privilegeService.getUserId(session))) {
      postDAO.delete(post);
    } else {
      response.setStatus(401);
      response.getWriter().append("401");
    }
  }
}