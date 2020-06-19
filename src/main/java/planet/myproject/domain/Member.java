package planet.myproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    private int userMoney = 100000;

    @OneToMany(mappedBy = "member")
    private List<Join> joinList = new ArrayList<>();

    @Builder
    public Member(Long id, String userId, String password, String name){
        this.id = id;
        this.userId = userId;
        this.password= password;
        this.name = name;
        this.userMoney= 100000;
    }



}
