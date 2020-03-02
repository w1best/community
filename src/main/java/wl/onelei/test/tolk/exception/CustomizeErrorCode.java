package wl.onelei.test.tolk.exception;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.exception
 * @ClassName: CustomizeErrorCode
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/2 23:26
 * @Version: 1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("我自定义的异常");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
