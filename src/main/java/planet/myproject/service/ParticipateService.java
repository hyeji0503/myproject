package planet.myproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import planet.myproject.domain.Item;
import planet.myproject.domain.Participate;
import planet.myproject.domain.Member;
import planet.myproject.repository.ItemRepository;
import planet.myproject.repository.ParticipateRepository;
import planet.myproject.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParticipateService {

    private final MemberRepository memberRepository;
    private final ParticipateRepository participateRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long participate(String username, Long itemId) {

        //엔티티 조회
        Optional<Member> optionalMember = memberRepository.findByUserId(username);
        Member member = optionalMember.get();
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        Item item = optionalItem.get();

        //주문 생성
        Participate participate = Participate.createParticipate(member, item);

        //주문 저장
        participateRepository.save(participate);
        return participate.getId();
    }

    public List<Participate> findByMemberId(Long memberId) {
        return participateRepository.findByMemberId(memberId);
    }


}
