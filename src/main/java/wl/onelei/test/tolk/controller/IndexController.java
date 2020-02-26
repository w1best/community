package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.dto.PaginationDTO;
import wl.onelei.test.tolk.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size) {
        PaginationDTO paginations = questionService.list(page,size);
        model.addAttribute("paginations",paginations);
        return "index";
    }
}
