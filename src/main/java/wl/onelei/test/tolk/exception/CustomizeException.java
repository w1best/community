package wl.onelei.test.tolk.exception;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.exception
 * @ClassName: CustomizeException
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/2 23:00
 * @Version: 1.0
 */
public class CustomizeException extends RuntimeException {

    private String message;

    private Integer code;

    public CustomizeException(ICustomizeErrorCode message) {
        this.code = message.getCode();
        this.message = message.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
