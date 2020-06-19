package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @OneToMany(mappedBy = "item")
    private List<Join> joinList = new ArrayList<>();


    /**
     * 수정필요
     */
    //연관관계 메서드
    public void addItemContents(ItemContents itemContents) {
        itemContentsList.add(itemContents);
        itemContents.setItem(this);
    }


    //item 가격 조회 수정필요,,
    public int getItemTotalPrice(List<ItemContents> itemContentsList) {
        int totalPrice = 0;
        for (ItemContents itemContents : itemContentsList) {
            totalPrice += itemContents.getItemContentsPrice();
        }
        return totalPrice;
    }


}
