package cn.graydove.activity.service;

import cn.graydove.activity.model.dto.ActivityDTO;
import cn.graydove.activity.model.entity.Activity;
import org.springframework.data.domain.Page;

public interface ActivityService {

    Page<Activity> getAllActivity(Integer page, Integer size);

    Page<Activity> findActivities(String key, Integer page, Integer size);

    Integer addActivity(ActivityDTO activity, Integer creatorId);
}
