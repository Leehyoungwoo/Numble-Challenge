package numble.challenge.member.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    void withdraw(Long memberId);

    List<Item> findItemByMember(Long memberId);

    void updateMember(Long memberId, String name, String email, String nickname, String phone);

}
