package planet.myproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IdeaForm {
    private Long id;

    private String title;
    private String text;
}
