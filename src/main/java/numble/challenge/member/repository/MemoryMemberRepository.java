//package numble.challenge.member.repository;
//
//import numble.challenge.domain.model.entity.Member;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//public class MemoryMemberRepository  {
//
//    private static final Map<Long, Member> memberStore = new HashMap<>();
//    private static Long sequence = 0L;
//
//    public Member save(Member member) {
//        member.setId(++sequence);
//        memberStore.put(sequence, member);
//        return member;
//    }
//
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(memberStore.get(id));
//    }
//
//    public List<Member> findAll() {
//        return new ArrayList<>(memberStore.values());
//    }
//
//    public void clearMemberStore() {
//        memberStore.clear();
//    }
//}
