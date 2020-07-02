package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int itemPrice; //상품 가격

    private int period; //보장 기간

    private int totalMoney; //총 적립금

    private int memberCount; //가입 멤버수

    private String itemExplanation;

    private String makerId;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemContents> itemContentsList = new ArrayList<>();


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Participate> participateList = new ArrayList<>();


    //연관관계 메서드
    public void addItemContents(ItemContents itemContents) {
        itemContentsList.add(itemContents);
        itemContents.setItem(this);
    }


    //총 적립금
    public int getItemTotalPrice() {
        return getItemPrice() * getMemberCount();
    }

    //가입 멤버수 증가
    public void addMember() {
        int addCount = this.memberCount +1;
        this.memberCount = addCount;
    }


}
