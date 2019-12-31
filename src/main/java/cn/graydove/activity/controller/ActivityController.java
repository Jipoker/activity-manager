package cn.graydove.activity.controller;

import cn.graydove.activity.enums.ResponseStatus;
import cn.graydove.activity.model.dto.ActivityDTO;
import cn.graydove.activity.model.entity.Activity;
import cn.graydove.activity.model.vo.Response;
import cn.graydove.activity.model.vo.ResponseFactory;
import cn.graydove.activity.service.ActivityService;
import cn.graydove.activity.utils.RequestUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public Response getAllActivities(Integer page, Integer size, String key) {
        Page<Activity> allActivities;
        if (StringUtils.isEmpty(key))
            allActivities  = activityService.getAllActivity(page, size);
        else
            allActivities = activityService.findActivities(key, page, size);
        return ResponseFactory.success(allActivities);
    }

    @PostMapping("/activity")
    public Response release(HttpRequest request, ActivityDTO activity) {
        Integer userId = RequestUtils.getUser(request);
        Integer id = activityService.addActivity(activity, userId);
        if (id > 0)
            return ResponseFactory.success();
        else
            return ResponseFactory.error(ResponseStatus.SERVER_ERROR);
    }

}
