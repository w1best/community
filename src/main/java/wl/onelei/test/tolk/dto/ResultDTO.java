package wl.onelei.test.tolk.dto;

import lombok.Data;
import wl.onelei.test.tolk.exception.CustomizeErrorCode;
import wl.onelei.test.tolk.exception.CustomizeException;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.dto
 * @ClassName: ResultDTO
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/5 22:00
 * @Version: 1.0
 */
@Data
public class ResultDTO {

    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode targetParamNotFound) {
        return ResultDTO.errorOf(targetParamNotFound.getCode(),targetParamNotFound.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException targetParamNotFound) {
        return ResultDTO.errorOf(targetParamNotFound.getCode(),targetParamNotFound.getMessage());
    }
    public static Object okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
}
