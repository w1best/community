package wl.onelei.test.tolk.model;

import lombok.Data;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.model
 * @ClassName: Question
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/6 20:26
 * @Version: 1.0
 */
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;


}
