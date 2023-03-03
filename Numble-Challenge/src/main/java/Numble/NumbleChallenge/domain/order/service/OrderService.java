package Numble.NumbleChallenge.domain.order.service;

import Numble.NumbleChallenge.domain.order.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long memberId, Long itemId, int count);
    void cancelOrder(Long orderId);
    List<Order> findAllOrder();

    List<Order> findOrderByMember(Long memberId);
}
