package planet.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planet.myproject.domain.Contents;

import java.util.List;
import java.util.Optional;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
    Optional<Contents> findByContentsNum(int contentsNum);
}
