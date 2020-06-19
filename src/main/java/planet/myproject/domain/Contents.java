package planet.myproject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Contents {

    @Id @GeneratedValue
    @Column(name = "contents_id")
    private Long id;

    private int contentsNum;
    private String contentsName;
    private int contentsPrice;

    //'contents'와 'itemContents'의 oneToMany 연관관계 만들지 않음.
    // 조회할 일이 없을것 같기 때문.


}
