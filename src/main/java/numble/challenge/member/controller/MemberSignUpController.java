package numble.challenge.member.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberSignUpController {

    private final MemberService memberService;

    @GetMapping("/api/member/sign-up/")
    public String signUpForm(Model model) {
        model.addAttribute("member", new Member());
        return "sign-up-form";
    }

    @PostMapping("/api/member")
    public String signUp(@RequestBody MemberSaveDto memberSaveDto) {
        memberService.join(Member.toEntity(memberSaveDto));
        return "redirect: log-in-form";
    }

}
