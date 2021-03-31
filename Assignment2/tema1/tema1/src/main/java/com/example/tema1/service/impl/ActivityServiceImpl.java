package com.example.tema1.service.impl;

import com.example.tema1.entity.Activity;
import com.example.tema1.repository.ActivityRepository;
import com.example.tema1.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

@Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override

    public Activity save(Activity activity) {

        if (activity.getActivityId() != null) {
            activity = activityRepository.findByActivityId(activity.getActivityId());
        } else {
            activity = new Activity();
        }


        return activityRepository.save(activity);
    }

}
