package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.mapper.QuestionMapper;
import wl.onelei.test.tolk.model.Question;
import wl.onelei.test.tolk.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.controller
 * @ClassName: PublishController
 * @Author: Administrator
 * @Description: publish
 * @Date: 2020/2/5 21:58
 * @Version: 1.0
 */
@Controller
public class PublishController {


    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam("title")String title,
                          @RequestParam("description")String description,
                          @RequestParam("tag")String tag,
                          HttpServletRequest request,
                          Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(StringUtils.isEmpty(title)){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }

        if(StringUtils.isEmpty(description)){
            model.addAttribute("error","内容不能为空");
            return "publish";
        }

        if(StringUtils.isEmpty(tag)){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");

        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());


        questionMapper.createQuestoin(question);
        return "redirect:/";
    }
}
