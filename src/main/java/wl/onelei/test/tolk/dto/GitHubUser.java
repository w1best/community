package wl.onelei.test.tolk.dto;

import lombok.Data;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: GitHubUser
 * @Author: Administrator
 * @Description: githubuser
 * @Date: 2020/2/3 18:37
 * @Version: 1.0
 */
@Data
public class GitHubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;


}
