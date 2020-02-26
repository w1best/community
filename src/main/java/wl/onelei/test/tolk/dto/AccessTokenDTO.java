package wl.onelei.test.tolk.dto;

import lombok.Data;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: AccessTokenDTO
 * @Author: Administrator
 * @Description: dto
 * @Date: 2020/2/3 17:09
 * @Version: 1.0
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
