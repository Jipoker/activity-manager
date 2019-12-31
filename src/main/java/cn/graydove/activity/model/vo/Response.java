package cn.graydove.activity.model.vo;

import cn.graydove.activity.enums.ResponseStatus;
import lombok.Data;

@Data
public abstract class Response {

    private Integer code;

    private String message;

    public Response(ResponseStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public abstract Object getData();
}
