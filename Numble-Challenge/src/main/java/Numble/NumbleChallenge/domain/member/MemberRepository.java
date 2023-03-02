package Numble.NumbleChallenge.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    private static Map<Long, Member> memberStore = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    private static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        memberStore.put(member.getId(), member);
        return member;
    }

    public Member findById(Member member) {
        return memberStore.get(member.getId());
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    public void clearItemStore() {
        memberStore.clear();
    }
}
