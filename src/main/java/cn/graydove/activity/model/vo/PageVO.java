package cn.graydove.activity.model.vo;

import cn.graydove.activity.enums.ResponseStatus;
import cn.graydove.activity.model.dto.PageDTO;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageVO extends Response {

    public <T> PageVO(Page<T> page) {
        super(ResponseStatus.OK);
        this.data = new PageDTO<>(page);
    }

    private PageDTO data;

}
