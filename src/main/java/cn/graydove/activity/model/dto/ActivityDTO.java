package cn.graydove.activity.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ActivityDTO {
    private String name;

    private String introduce;

    private String address;

    private Date startTime;

    private Date FinishTime;

    private Integer maxNumber;

    private List<String> activityField;
}
