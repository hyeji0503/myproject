package planet.myproject.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Idea {

    @Id @GeneratedValue
    @Column(name = "idea_id")
    private Long id;

    private String title;

    private String text;

    private String giverId;
}
