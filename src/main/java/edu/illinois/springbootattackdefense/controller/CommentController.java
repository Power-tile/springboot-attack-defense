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

import edu.illinois.springbootattackdefense.dao.CommentDAO;
import edu.illinois.springbootattackdefense.dao.PostDAO;
import edu.illinois.springbootattackdefense.model.CommentDTO;
import edu.illinois.springbootattackdefense.model.PostDTO;
import edu.illinois.springbootattackdefense.service.PrivilegeService;
import edu.illinois.springbootattackdefense.vo.CommentAddVO;
import edu.illinois.springbootattackdefense.vo.CommentViewVO;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
  @Autowired
  CommentDAO commentDAO;

  @Autowired
  UserController userController;

  @Autowired
  PostDAO postDAO;

  @Autowired
  PrivilegeService privilegeService;

  @RequestMapping("/get/{id}")
  public List<CommentViewVO> getByPostId(@PathVariable(name = "id") Integer postId) {
    List<CommentDTO> comments = commentDAO.findAllByPostId(postId);
    List<CommentViewVO> ret = new ArrayList<CommentViewVO>();
    for (CommentDTO comment : comments) {
      ret.add(new CommentViewVO(comment, userController.getUserInfo(comment.getUserId())));
    }
    return ret;
  }

  @PostMapping("/add")
  public void addComment(@RequestBody CommentAddVO commentAddVO, HttpSession session, HttpServletResponse response) throws IOException {
    if (privilegeService.getUserId(session) == null) {
      response.setStatus(401);
      response.getWriter().append("401");
      return;
    }

    commentDAO.save(new CommentDTO(commentAddVO, privilegeService.getUserId(session)));
  }

  @RequestMapping("/delete/{id}")
  public void deleteComment(@PathVariable(name = "id") Integer id, HttpSession session, HttpServletResponse response) throws IOException {
    CommentDTO comment = commentDAO.getById(id);
    PostDTO post = postDAO.getById(comment.getPostId());
    if (privilegeService.validatePrivilege(session, 2) ||
       (privilegeService.validatePrivilege(session, 1) && privilegeService.getUserId(session) == post.getUserId()) ||
       (privilegeService.validatePrivilege(session, 0) && privilegeService.getUserId(session) == comment.getUserId())) {
      commentDAO.delete(comment);
    } else {
      response.setStatus(401);
      response.getWriter().append("401");
    }
  }
}
