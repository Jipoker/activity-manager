package cn.graydove.activity.exception;

public class DataBaseException extends RuntimeException {
    public DataBaseException() {
        this("数据库操作异常");
    }

    public DataBaseException(String message) {
        super(message);
    }
}
