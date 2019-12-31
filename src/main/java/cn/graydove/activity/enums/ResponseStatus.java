package cn.graydove.activity.enums;


import lombok.Getter;

@Getter
public enum ResponseStatus {
    OK(0, "正常"),
    FORBIDDEN(1, "无权限"),
    SERVER_ERROR(2, "服务器异常");

    private int code;

    private String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
