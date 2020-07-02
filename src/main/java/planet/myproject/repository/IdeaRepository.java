package planet.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planet.myproject.domain.Idea;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
}
