package wl.onelei.test.tolk.model;

import lombok.Data;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.MODEL
 * @ClassName: User
 * @Author: Administrator
 * @Description: user
 * @Date: 2020/2/4 18:54
 * @Version: 1.0
 */
@Data
public class User {

    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
