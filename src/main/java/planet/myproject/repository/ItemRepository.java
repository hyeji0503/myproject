package planet.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planet.myproject.domain.Item;
import planet.myproject.domain.Member;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemName);

}
