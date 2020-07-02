package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import planet.myproject.domain.*;
import planet.myproject.service.IdeaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @GetMapping("/idea/new")
    public String createIdea(Model model) {

        model.addAttribute("form", new IdeaForm());

        return "/idea/ideaCreateForm";
    }

    @PostMapping(value = "/idea/new")
    public String makeIdea(IdeaForm form) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        Idea idea = new Idea();
        idea.setGiverId(username);
        idea.setTitle(form.getTitle());
        idea.setText(form.getText());

        ideaService.saveIdea(idea);

        return "redirect:/idea/ideaList";
    }

    @GetMapping("/idea/ideaList")
    public String ideaList(Model model) {
        List<Idea> ideas = ideaService.findIdeas();
        model.addAttribute("ideas",ideas);

        return "/idea/ideaList";
    }


    @GetMapping(value = "/idea/details/{ideaId}")
    public String ideaDetails(@PathVariable("ideaId") Long ideaId, Model model) {

        //아이템 조회
        Optional<Idea> optionalIdea = ideaService.findById(ideaId);
        Idea idea = optionalIdea.get();
        model.addAttribute("idea", idea);

        return "/idea/ideaDetails";
    }

}
