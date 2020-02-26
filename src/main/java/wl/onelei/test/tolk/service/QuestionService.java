package wl.onelei.test.tolk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wl.onelei.test.tolk.dto.PaginationDTO;
import wl.onelei.test.tolk.dto.QuestionDTO;
import wl.onelei.test.tolk.mapper.QuestionMapper;
import wl.onelei.test.tolk.mapper.UserMapper;
import wl.onelei.test.tolk.model.Question;
import wl.onelei.test.tolk.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.service
 * @ClassName: QuestionService
 * @Author: Administrator
 * @Description: questionservice
 * @Date: 2020/2/11 1:54
 * @Version: 1.0
 */
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;


    public PaginationDTO list(Integer page, Integer size){
        PaginationDTO pagination = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        pagination.setPagination(totalCount,page,size);

        if(page < 1){
            page = 1;
        }

        if (page > pagination.getTotalPage()){
            page = pagination.getTotalPage();
        }
        Integer offSet = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        List<Question> questions = questionMapper.list(offSet,size);
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagination.setQuestionDTOs(questionDTOS);
        return pagination;
    }

    public PaginationDTO list(Integer id, Integer page, Integer size) {
        PaginationDTO pagination = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserID(id);
        pagination.setPagination(totalCount,page,size);

        if(page < 1){
            page = 1;
        }

        if (page > pagination.getTotalPage()){
            page = pagination.getTotalPage();
        }
        Integer offSet = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        List<Question> questions = questionMapper.listByUserID(id,offSet,size);
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagination.setQuestionDTOs(questionDTOS);
        return pagination;
    }
}
