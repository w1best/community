package wl.onelei.test.tolk.dto;

import lombok.Data;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: CommentDTO
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/4 22:35
 * @Version: 1.0
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
