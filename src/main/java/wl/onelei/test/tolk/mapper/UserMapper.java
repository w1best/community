package wl.onelei.test.tolk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);
}
