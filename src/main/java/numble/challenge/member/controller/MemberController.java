package numble.challenge.member.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.controller.dto.MemberUpdateDto;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    private MemberRepository memberRepository;

    @GetMapping("/api/member/sign-up/")
    public String signUpForm(Model model) {
        model.addAttribute("member", new Member());
        return "sign-up-form";
    }

    @PostMapping("/auth/member")
    public String signUp(@RequestBody MemberSaveDto memberSaveDto) {
        memberService.join(Member.toEntity(memberSaveDto));
        return "redirect: log-in-form";
    }

    @GetMapping("/api/member/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "update-form";
    }

    @PostMapping("/api/member/{id}/update")
    public String update(@PathVariable Long id, @RequestBody MemberUpdateDto memberUpdateDto) {
        memberService.updateMember(id, memberUpdateDto);
        return "redirect:/";
    }

    @PostMapping("/member/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        memberService.withdraw(id);
        return "redirect:/";
    }

    @PostMapping("/member/{id}/items")
    public String findItemByMember(@PathVariable("id") Long id, Model model) {
        model.addAttribute("items", memberService.findItemByMember(id));
        return "member-itemList";
    }
}
