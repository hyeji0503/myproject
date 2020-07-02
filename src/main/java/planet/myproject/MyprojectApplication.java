package planet.myproject;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import planet.myproject.controller.MainController;
import planet.myproject.domain.Contents;
import planet.myproject.service.ContentsService;
import planet.myproject.service.MemberService;

@SpringBootApplication
public class  MyprojectApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyprojectApplication.class, args);
	}

}
