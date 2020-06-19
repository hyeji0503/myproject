package planet.myproject.dto;


import lombok.*;
import planet.myproject.domain.Member;

@Getter @Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private int userMoney = 100000;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .userId(userId)
                .password(password)
                .name(name)
                .build();
    }

    @Builder
    public MemberDto(Long id, String userId, String password, String name) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.userMoney = 100000;
    }
}
