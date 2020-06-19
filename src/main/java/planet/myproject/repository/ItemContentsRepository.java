package planet.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planet.myproject.domain.Contents;
import planet.myproject.domain.ItemContents;

import java.util.List;

public interface ItemContentsRepository extends JpaRepository<ItemContents, Long> {
    List<ItemContents> findByItemId(Long itemId);

}
