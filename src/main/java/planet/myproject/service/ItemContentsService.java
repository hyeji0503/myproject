package planet.myproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import planet.myproject.domain.ItemContents;
import planet.myproject.repository.ItemContentsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemContentsService {

    private final ItemContentsRepository itemContentsRepository;

}
