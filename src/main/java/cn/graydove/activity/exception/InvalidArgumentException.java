package cn.graydove.activity.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
        this("无效参数异常");
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
