package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Join {

    @Id @GeneratedValue
    @Column(name = "join_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDateTime joinDate; //주문시간


    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getJoinList().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getJoinList().add(this);
    }

    //==생성 메서드==//
    public static Join createJoin(Member member, Item item) {
        Join join = new Join();
        join.setMember(member);
        join.setItem(item);
        join.setJoinDate(LocalDateTime.now());
        return join;
    }
}
