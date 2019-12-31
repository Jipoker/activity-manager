package cn.graydove.activity.reposiory;

import cn.graydove.activity.model.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query("from Activity a where a.name like %?1% or a.creator.name like %?1%")
    Page<Activity> findActivitiesByKey(String key, Pageable pageable);
}
