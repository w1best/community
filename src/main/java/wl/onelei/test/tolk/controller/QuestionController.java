package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wl.onelei.test.tolk.dto.QuestionDTO;
import wl.onelei.test.tolk.service.QuestionService;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.controller
 * @ClassName: QuestionMapper
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/27 20:50
 * @Version: 1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id,
                           Model model){
        questionService.incCount(id);
        QuestionDTO questionDTO = questionService.getQuestionById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
