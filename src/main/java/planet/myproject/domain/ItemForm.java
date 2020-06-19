package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ItemForm {
    private Long id;

    private String itemName;
    private int period;
    private String itemExplanation;
    private int contentsNum;


    //private String itemContents;

}
