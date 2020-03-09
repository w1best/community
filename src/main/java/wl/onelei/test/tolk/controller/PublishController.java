package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.dto.QuestionDTO;
import wl.onelei.test.tolk.model.Question;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.service.QuestionService;

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
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id")Long id,
                       Model model){
        QuestionDTO question = questionService.getQuestionById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",id);
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam("title")String title,
                          @RequestParam("description")String description,
                          @RequestParam("tag")String tag,
                          @RequestParam("id")Long id,
                          HttpServletRequest request,
                          Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("id",id);

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
        question.setId(id);

        questionService.createOrUpdate(question);
        return "redirect:/";
    }
}
