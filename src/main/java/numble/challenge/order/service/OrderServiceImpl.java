package numble.challenge.order.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.ItemCart;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.item.repository.ItemRepository;
import numble.challenge.itemCart.repository.ItemCartRepository;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final ItemCartRepository itemCartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository, MemberRepository memberRepository, ItemCartRepository itemCartRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
        this.itemCartRepository = itemCartRepository;
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
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));

        order.cancel();
    }

    @Transactional(readOnly = false)
    @Override
    public List<Order> findAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Transactional(readOnly = false)
    @Override
    public void addItemCart(Long itemCartId, Long memberId, Long itemId, int count) {
        ItemCart itemCart = itemCartRepository.findById(itemCartId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장바구니입니다."));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));

        if (itemCart.getItems().containsKey(item)) {
            int existCount = itemCart.getItems().get(item);
            itemCart.getItems().put(item, existCount + count);
        } else {
            itemCart.getItems().put(item, count);
        }

        itemCartRepository.save(itemCart);
    }

    @Transactional(readOnly = false)
    @Override
    public ItemCart findItemCart(Long itemCartId) {
        return itemCartRepository.findById(itemCartId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장바구니입니다"));
    }

    @Transactional(readOnly = false)
    @Override
    public List<Member> findAllMemberByProduct(Long itemId) {
        return orderRepository.findMemberByItem(itemId);
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
