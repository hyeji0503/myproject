package planet.myproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import planet.myproject.domain.Contents;
import planet.myproject.repository.ContentsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContentsService {

    private final ContentsRepository contentsRepository;

    @Transactional
    public void saveContents(Contents contents) {
        contentsRepository.save(contents);
    }

    public List<Contents> findContents() {
        return contentsRepository.findAll();
    }


}
