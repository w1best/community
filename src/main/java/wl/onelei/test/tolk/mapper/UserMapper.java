package wl.onelei.test.tolk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wl.onelei.test.tolk.model.User;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.mapper
 * @ClassName: UserMapper
 * @Author: Administrator
 * @Description: usermapper
 * @Date: 2020/2/4 19:23
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
