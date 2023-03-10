package numble.challenge.order.service;

import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;

import java.util.List;

public interface OrderService {

    void createOrder(Long memberId, Long itemId, int count);

    void cancelOrder(Long orderId);

    List<Order> findAllOrder();

    void addItemCart(Long cartId, Long memberId, Long itemId, int count);

    void findItemCart();

    void CustomerSupport();

    void writeReview();

    List<Member> findAllMemberByProduct(Long itemId);

}
