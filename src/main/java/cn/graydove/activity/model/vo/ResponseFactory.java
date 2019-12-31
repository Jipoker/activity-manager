package cn.graydove.activity.model.vo;

import cn.graydove.activity.exception.InvalidArgumentException;
import cn.graydove.activity.enums.ResponseStatus;
import org.springframework.data.domain.Page;

public final class ResponseFactory {

    private ResponseFactory(){}

    public static <T> PageVO success(Page<T> page) {
        return new PageVO(page);
    }

    public static StringVO success(String msg) {
        return new StringVO(ResponseStatus.OK, msg);
    }

    public static StringVO success() {
        return new StringVO(ResponseStatus.OK, null);
    }

    public static StringVO error(ResponseStatus status) {
        return error(status, status.getMessage());
    }

    public static StringVO error(ResponseStatus status, String msg) {
        if (status == ResponseStatus.OK)
            throw new InvalidArgumentException();
        return response(status, msg);
    }

    public static StringVO response(ResponseStatus status, String msg) {
        return new StringVO(status, msg);
    }
}
