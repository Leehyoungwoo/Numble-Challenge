package numble.challenge.member.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberSignUpController {

    private final MemberService memberService;

    @PostMapping("/api/member")
    public String create(@RequestBody MemberSaveDto memberSaveDto) {
        memberService.join(Member.toEntity(memberSaveDto));
        return "sign-up-form";
    }


}
