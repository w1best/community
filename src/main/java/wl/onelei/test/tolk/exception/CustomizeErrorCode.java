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
    QUESTION_NOT_FOUND(2001, "问题已经不存在."),
    TARGET_PARAM_NOT_FOUND(2002, "未选择任何评论回复."),
    NO_LOGIN(2003, "未登录,不能评论,请先登录."),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2001, "该评论已经不存在."),
    SYS_CODE(2005,"系统正忙,稍后再试.");

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
