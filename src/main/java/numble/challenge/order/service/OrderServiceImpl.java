package numble.challenge.order.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.item.repository.ItemRepository;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository, MemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = false)
    @Override
    public void createOrder(Long memberId, Long itemId, int count) {
        Member orderMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Item OrderItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        Order order = getOrder(count, orderMember, OrderItem);
        orderRepository.save(order);
    }

    @Transactional(readOnly = false)
    @Override
    public void cancelOrder(Long orderId) {

    }

    @Transactional(readOnly = false)
    @Override
    public List<Order> findAllOrder() {
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void addCarTItem() {

    }

    @Transactional(readOnly = false)
    @Override
    public void findCartItem() {

    }

    @Transactional(readOnly = false)
    @Override
    public void CustomerSupport() {

    }

    @Transactional(readOnly = false)
    @Override
    public void writeReview() {

    }

    @Transactional(readOnly = false)
    @Override
    public List<Member> findAllCustomerByProduct() {
        return null;
    }

    private Order getOrder(int count, Member orderMember, Item OrderItem) {
        Order order = Order.builder()
                .member(orderMember)
                .item(OrderItem)
                .count(count)
                .build();
        return order;
    }
}
