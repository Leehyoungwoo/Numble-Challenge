package numble.challenge.member.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.controller.dto.MemberUpdateDto;

import java.util.List;

public interface MemberService {

    void join(Member member);

    void withdraw(Long memberId);

    List<Item> findItemByMember(Long memberId);

    void updateMember(Long memberId, MemberUpdateDto memberUpdateDto);

}
