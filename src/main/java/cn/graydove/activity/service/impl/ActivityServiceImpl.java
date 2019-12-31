package cn.graydove.activity.service.impl;

import cn.graydove.activity.exception.DataBaseException;
import cn.graydove.activity.exception.InvalidArgumentException;
import cn.graydove.activity.model.dto.ActivityDTO;
import cn.graydove.activity.model.entity.Activity;
import cn.graydove.activity.model.entity.ActivityField;
import cn.graydove.activity.reposiory.ActivityFieldRepository;
import cn.graydove.activity.reposiory.ActivityRepository;
import cn.graydove.activity.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private ActivityFieldRepository activityFieldRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, ActivityFieldRepository activityFieldRepository) {
        this.activityRepository = activityRepository;
        this.activityFieldRepository = activityFieldRepository;
    }

    @Override
    public Page<Activity> getAllActivity(Integer page, Integer size) {
        return activityRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Activity> findActivities(String key, Integer page, Integer size) {
        return activityRepository.findActivitiesByKey(key, PageRequest.of(page, size));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Integer addActivity(ActivityDTO activity, Integer creatorId) {
        Activity bean = new Activity();
        BeanUtils.copyProperties(activity, bean, "activityField");

        Activity a = activityRepository.save(bean);
        if (a.getId() == null) {
            throw new DataBaseException();
        }

        bean.setActivityField(activity.getActivityField().stream().map(field -> {
            ActivityField activityField = new ActivityField();
            activityField.setName(field);
            activityFieldRepository.save(activityField);
            return activityField;
        }).collect(Collectors.toList()));

        a = activityRepository.save(bean);
        return a.getId();
    }
}


























































