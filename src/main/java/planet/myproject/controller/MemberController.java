package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import planet.myproject.dto.MemberDto;
import planet.myproject.service.MemberService;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberDto memberDto) {
        memberService.join(memberDto);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String login() {
        return "/members/login";
    }

    @GetMapping("/members/login/result")
    public String loginSuccess() {
        return "redirect:/";
    }

    @GetMapping("/members/logout/result")
    public String logoutSuccess() {
        return "/members/logout";
    }

    @GetMapping("/members/myInfo")
    public String myInfo() {
        return "/members/myInfo";
    }


}
