package wl.onelei.test.tolk.dto;

import lombok.Data;
import wl.onelei.test.tolk.model.User;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: QuestionDTO
 * @Author: Administrator
 * @Description: questiondto
 * @Date: 2020/2/11 1:52
 * @Version: 1.0
 */
@Data
public class QuestionDTO {
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
    private User user;
}
