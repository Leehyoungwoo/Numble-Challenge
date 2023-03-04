package numble.challenge.order.service;

import numble.challenge.domain.model.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long memberId, Long itemId, int count);

    void cancelOrder(Long orderId);

    List<Order> findAllOrder();

    List<Order> findOrderByMember(Long memberId);
}
