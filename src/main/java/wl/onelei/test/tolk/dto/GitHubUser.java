package wl.onelei.test.tolk.dto;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: GitHubUser
 * @Author: Administrator
 * @Description: githubuser
 * @Date: 2020/2/3 18:37
 * @Version: 1.0
 */
public class GitHubUser {

    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
