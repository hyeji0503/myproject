package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContentsForm {
    private Long id;

    private int contentsNum;
    private String contentsName;
    private int contentsPrice;
    private String contentsExplain;


}
