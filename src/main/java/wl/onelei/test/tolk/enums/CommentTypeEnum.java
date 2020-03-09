package wl.onelei.test.tolk.enums;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.enums
 * @ClassName: CommentTypeEnum
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/5 22:39
 * @Version: 1.0
 */
public enum CommentTypeEnum {

    QUESTION(1),
    COMMENT(2);

    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if(value.getType().equals(type)){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }
}
