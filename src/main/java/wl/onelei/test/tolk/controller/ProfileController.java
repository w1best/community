package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.dto.PaginationDTO;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.controller
 * @ClassName: ProfileController
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/25 21:54
 * @Version: 1.0
 */
@Controller
public class ProfileController {


    @Autowired
    private QuestionService questionService;

    @RequestMapping("/profile/{section}")
    public String profile(@PathVariable(name = "section") String section,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "2") Integer size) {
        User user = (User) request.getSession().getAttribute("user");
        if ("questions".equals(section)) {
            model.addAttribute("sectiom", "questions");
            model.addAttribute("sectionName", "我的问题");
        } else if ("replies".equals(section)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "我的回复");
        }

        PaginationDTO paginations = questionService.list(user.getId(), page, size);
        model.addAttribute("paginations",paginations);
        return "profile";
    }
}
