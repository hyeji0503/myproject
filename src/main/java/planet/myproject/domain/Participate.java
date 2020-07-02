package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Participate{

    @Id @GeneratedValue
    @Column(name = "participate_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getParticipateList().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getParticipateList().add(this);
    }

    //==생성 메서드==//
    public static Participate createParticipate(Member member, Item item) {
        Participate participate = new Participate();
        participate.setMember(member);
        participate.setItem(item);

        item.addMember();
        member.addJoinMoney(item.getItemPrice());

        return participate;
    }

}
