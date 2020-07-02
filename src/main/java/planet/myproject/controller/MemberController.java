package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import planet.myproject.domain.*;
import planet.myproject.dto.MemberDto;
import planet.myproject.repository.MemberRepository;
import planet.myproject.service.ItemService;
import planet.myproject.service.MemberService;
import planet.myproject.service.ParticipateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ItemService itemService;
    private final MemberRepository memberRepository;
    private final ParticipateService participateService;

    @GetMapping("/new")
    public String createForm() {
        return "user/createMemberForm";
    }

    @PostMapping("/new")
    public String createMember(MemberDto memberDto) {
        memberService.join(memberDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/login/result")
    public String loginSuccess() {
        return "redirect:/";
    }

    @GetMapping("/logout/result")
    public String logoutSuccess() {
        return "redirect:/";
    }

    @GetMapping("/members/myInfo")
    public String myInfo() {
        return "/members/myInfo";
    }

    @GetMapping("/members/myItem")
    public String myItem(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Optional<Member> optionalMember = memberRepository.findByUserId(username);
        Member member = optionalMember.get();
        Long memberId = member.getId();

        List<Participate> participates = participateService.findByMemberId(memberId);
        List<Item> myItems = new ArrayList<>();

        for (int i = 0; i < participates.size(); i++) {
            Item item = participates.get(i).getItem();
            myItems.add(item);
        }

        model.addAttribute("myItems", myItems);

        return "/members/myItem";
    }


}
