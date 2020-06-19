package planet.myproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import planet.myproject.domain.Contents;
import planet.myproject.domain.Item;
import planet.myproject.domain.ItemContents;
import planet.myproject.repository.ItemContentsRepository;
import planet.myproject.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemContentsRepository itemContentsRepository;


    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long itemId) {
        return itemRepository.findById(itemId);
    }

    public List<ItemContents> findByItemId(Long itemId) {
        return itemContentsRepository.findByItemId(itemId);
    }


}
