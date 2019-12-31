package cn.graydove.activity.model.vo;

import cn.graydove.activity.enums.ResponseStatus;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class StringVO extends Response {

    private String data;

    public StringVO(ResponseStatus status) {
        this(status, null);
    }

    public StringVO(ResponseStatus status, String data) {
        super(status);
        this.data = StringUtils.isEmpty(data) ? status.getMessage() : data;
    }
}
