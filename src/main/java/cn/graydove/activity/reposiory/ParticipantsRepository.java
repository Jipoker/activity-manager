package cn.graydove.activity.reposiory;

import cn.graydove.activity.model.entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsRepository extends JpaRepository<Participants, Integer> {
}
