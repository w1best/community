package wl.onelei.test.tolk.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wl.onelei.test.tolk.dto.PaginationDTO;
import wl.onelei.test.tolk.dto.QuestionDTO;
import wl.onelei.test.tolk.exception.CustomizeException;
import wl.onelei.test.tolk.exception.CustomizeErrorCode;
import wl.onelei.test.tolk.mapper.QuestionCountMapper;
import wl.onelei.test.tolk.mapper.QuestionMapper;
import wl.onelei.test.tolk.mapper.UserMapper;
import wl.onelei.test.tolk.model.Question;
import wl.onelei.test.tolk.model.QuestionExample;
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

    @Autowired
    private QuestionCountMapper questionCountMapper;


    public PaginationDTO list(Integer page, Integer size){
        PaginationDTO pagination = new PaginationDTO();
        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        pagination.setPagination(totalCount,page,size);

        if(page < 1){
            page = 1;
        }

        if (page > pagination.getTotalPage()){
            page = pagination.getTotalPage();
        }
        Integer offSet = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        List<Question> questions = questionMapper
                .selectByExampleWithBLOBsWithRowbounds(new QuestionExample(),new RowBounds(offSet,size));
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagination.setQuestionDTOs(questionDTOS);
        return pagination;
    }

    public PaginationDTO list(Long id, Integer page, Integer size) {
        PaginationDTO pagination = new PaginationDTO();
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andIdEqualTo(id);
        Integer totalCount = (int) questionMapper.countByExample(example);
        pagination.setPagination(totalCount,page,size);

        if(page < 1){
            page = 1;
        }

        if (page > pagination.getTotalPage()){
            page = pagination.getTotalPage();
        }
        Integer offSet = size * (page - 1);
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(id);
        List<Question> questions = questionMapper
                .selectByExampleWithRowbounds(questionExample,new RowBounds(offSet,size));
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        pagination.setQuestionDTOs(questionDTOS);
        return pagination;
    }

    public QuestionDTO getQuestionById(Long id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question == null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        System.out.println(question.getCreator());
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            questionMapper.insert(question);
        }else {
            Question updateQuestion = new Question();
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            updateQuestion.setCreator(question.getCreator());
            updateQuestion.setGmtCreate(question.getGmtCreate());
            updateQuestion.setGmtModified(question.getGmtModified());
//            updateQuestion.setLikeCount(question.getLikeCount());
//            updateQuestion.setViewCount(question.getViewCount());
//            updateQuestion.setCommentCount(question.getCommentCount());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                    .andIdEqualTo(question.getId());
            questionMapper.updateByExampleWithBLOBs(updateQuestion, questionExample);
        }
    }

    public void incCount(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionCountMapper.incCount(question);
    }
}
