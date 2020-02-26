package wl.onelei.test.tolk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wl.onelei.test.tolk.model.Question;

import java.util.List;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.mapper
 * @ClassName: QuestionMapper
 * @Author: Administrator
 * @Description: 插入问题
 * @Date: 2020/2/6 20:20
 * @Version: 1.0
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void createQuestoin(Question question);

    @Select("select * from question limit #{offSet},#{size}")
    List<Question> list(Integer offSet, Integer size);

    @Select("select * from question where creator = #{userID} limit #{offSet},#{size}")
    List<Question> listByUserID(@Param("userID") Integer userID, @Param("offSet") Integer offSet, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question  where creator = #{userID}")
    Integer countByUserID(@Param("userID")Integer userID);
}
