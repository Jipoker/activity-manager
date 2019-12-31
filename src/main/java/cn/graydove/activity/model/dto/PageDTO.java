package cn.graydove.activity.model.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    private List<T> content;

    private Integer totalPages;

    private Long totalElements;

    public PageDTO(Page<T> page) {
        content = page.getContent();
        totalElements = page.getTotalElements();
        totalPages = page.getTotalPages();
    }
}
