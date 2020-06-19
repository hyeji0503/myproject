package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import planet.myproject.domain.Contents;
import planet.myproject.domain.ContentsForm;
import planet.myproject.service.ContentsService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ContentsService contentsService;

    @GetMapping("/admin")
    public String adminMain() {
        return "/admin/adminMain";
    }

    @GetMapping("/admin/contents")
    public String contentsList(Model model){

        List<Contents> contentsList = contentsService.findContents();
        model.addAttribute("contentsList", contentsList);

        return "/admin/contents";
    }

    @GetMapping("/admin/contents/new")
    public String createContents(Model model) {
        model.addAttribute("form", new ContentsForm());
        return "/admin/contentsCreateForm";
    }

    @PostMapping("/admin/contents/new")
    public String create(ContentsForm form) {

        Contents contents = new Contents();
        contents.setContentsNum(form.getContentsNum());
        contents.setContentsName(form.getContentsName());
        contents.setContentsPrice(form.getContentsPrice());

        contentsService.saveContents(contents);

        return "redirect:/admin/contents";
    }

}
