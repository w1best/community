package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wl.onelei.test.tolk.dto.CommentDTO;
import wl.onelei.test.tolk.dto.ResultDTO;
import wl.onelei.test.tolk.exception.CustomizeErrorCode;
import wl.onelei.test.tolk.model.Comment;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.service.CommentService;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.controller
 * @ClassName: CommentController
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/4 22:31
 * @Version: 1.0
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/comment",method =  RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setCommentator(1L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
