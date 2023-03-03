package Numble.NumbleChallenge.domain.order;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryOrderRepository implements OrderRepository{

    private final static Map<Long, Order> orderStore = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Order save(Order order) {
        order.setId(++sequence);
        orderStore.put(sequence, order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderStore.get(id));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderStore.values());
    }

    @Override
    public List<Order> findByMemberId(Long memberId) {
        return orderStore.values().stream()
                .filter(order -> order.getMember().getId().equals(memberId))
                .collect(Collectors.toList());
    }

    public void clearStore() {
        orderStore.clear();
    }
}
