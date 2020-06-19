package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class ItemContents {

    @Id @GeneratedValue
    @Column(name = "item_contents_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contents_id")
    private Contents contents;

    private int itemContentsPrice;


    /**
     * 수정필요
     */
    //==생성메서드==//
    public static ItemContents contentsToItemContents(Contents contents) {
        ItemContents itemContents = new ItemContents();
        itemContents.setContents(contents);

        return itemContents;
    }

}
