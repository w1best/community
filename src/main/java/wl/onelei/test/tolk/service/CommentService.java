package wl.onelei.test.tolk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.onelei.test.tolk.enums.CommentTypeEnum;
import wl.onelei.test.tolk.exception.CustomizeErrorCode;
import wl.onelei.test.tolk.exception.CustomizeException;
import wl.onelei.test.tolk.mapper.CommentMapper;
import wl.onelei.test.tolk.mapper.QuestionCountMapper;
import wl.onelei.test.tolk.mapper.QuestionMapper;
import wl.onelei.test.tolk.model.Comment;
import wl.onelei.test.tolk.model.Question;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.service
 * @ClassName: CommentService
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/5 22:44
 * @Version: 1.0
 */
@Service
public class CommentService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionCountMapper questionCountMapper;

    @Transactional
    public void insert(Comment comment) {
        // 判断父评论是否存在
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        // 判断准备回复的评论是否还存在
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        // 判断回复的是评论还是问题
        if (comment.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            // 回复问题
            Question dbQuestion = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (dbQuestion == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            // 设置步长为1
            dbQuestion.setCommentCount(1);
            questionCountMapper.incCommentCount(dbQuestion);
        }
    }
}
