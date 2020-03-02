package wl.onelei.test.tolk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wl.onelei.test.tolk.mapper.UserMapper;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.model.UserExample;

import java.util.List;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.service
 * @ClassName: UserService
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/29 19:30
 * @Version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertOrUpdate(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());

        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() > 0){
            // 更新
            User dbUser = users.get(0);

            User userUpdate = new User();
            userUpdate.setAvatarUrl(user.getAvatarUrl());
            userUpdate.setGmtModified(user.getGmtModified());
            userUpdate.setToken(user.getToken());
            userUpdate.setName(user.getName());

            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(userUpdate, example);
        }else {
            // 插入
            userMapper.insert(user);
        }

    }
}
