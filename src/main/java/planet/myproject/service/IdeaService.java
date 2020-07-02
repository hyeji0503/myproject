package planet.myproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import planet.myproject.domain.Idea;
import planet.myproject.domain.Item;
import planet.myproject.repository.IdeaRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class IdeaService {

    private final IdeaRepository ideaRepository;

    @Transactional
    public Long saveIdea(Idea idea) {
        ideaRepository.save(idea);
        return idea.getId();
    }

    public List<Idea> findIdeas() {
        return ideaRepository.findAll();
    }

    public Optional<Idea> findById(Long ideaId) {
        return ideaRepository.findById(ideaId);
    }

}
