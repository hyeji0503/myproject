package planet.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planet.myproject.domain.Participate;

import java.util.List;

public interface ParticipateRepository extends JpaRepository<Participate, Long> {
    List<Participate> findByMemberId(Long memberId);
}
