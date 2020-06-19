package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import planet.myproject.domain.Contents;
import planet.myproject.domain.Member;
import planet.myproject.service.ContentsService;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }


}
