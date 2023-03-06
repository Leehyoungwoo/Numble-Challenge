package numble.challenge.member.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberDeleteController {

    private final MemberService memberService;

    @PostMapping("/member/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        memberService.withdraw(id);
        return "redirect:/api/member";
    }
}
