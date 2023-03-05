package numble.challenge.member.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public MemberServiceImpl(MemberRepository memberRepository, OrderRepository orderRepository) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public void withdraw(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public List<Item> findItemByMember(Long memberId) {
        List<Order> orders = orderRepository.findByMemberId(memberId);
        List<Item> orderItems = new ArrayList<>();
        for (Order order : orders) {
            orderItems.add(order.getItem());
        }
        return orderItems;
    }

    @Override
    public void updateMember(Long memberId, String name, String email, String nickname, String phone) {
        Optional<Member> member = memberRepository.findById(memberId);
        member.ifPresent(m -> {
            m.update(name, email, nickname, phone);
        });
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        });
    }
}
