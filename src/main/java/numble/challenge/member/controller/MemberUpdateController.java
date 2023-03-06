package numble.challenge.member.controller;


import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.member.controller.dto.MemberUpdateDto;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberUpdateController {

    private MemberService memberService;
    private MemberRepository memberRepository;

    @GetMapping("/api/member/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "update-form";
    }

    @PostMapping("/api/member/{id}/update")
    public String update(@PathVariable Long id, @ModelAttribute("member")MemberUpdateDto memberUpdateDto) {
        memberService.updateMember(id, memberUpdateDto);
        return "redirect:/api/member";
    }
}
