package numble.challenge.member.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.member.controller.dto.MemberSaveDto;
import numble.challenge.member.controller.dto.MemberUpdateDto;
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

    @Transactional(readOnly = false)
    @Override
    public void join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    @Transactional(readOnly = false)
    @Override
    public void withdraw(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Transactional(readOnly = false)
    @Override
    public List<Item> findItemByMember(Long memberId) {
        List<Order> orders = orderRepository.findByMemberId(memberId);
        List<Item> orderItems = new ArrayList<>();
        for (Order order : orders) {
            orderItems.add(order.getItem());
        }
        return orderItems;
    }

    @Transactional(readOnly = false)
    @Override
    public void updateMember(Long memberId, MemberUpdateDto memberUpdateDto) {
       Member member = memberRepository.findById(memberId)
               .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

       member.update(memberUpdateDto);
    }

    @Transactional(readOnly = false)
    public void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByPhone(member.getPhone());
        result.ifPresent(m -> {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        });
    }
}
