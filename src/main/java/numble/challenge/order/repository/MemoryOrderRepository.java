package numble.challenge.order.repository;

import numble.challenge.domain.model.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryOrderRepository {

    private final static Map<Long, Order> orderStore = new HashMap<>();
    private static Long sequence = 0L;

    public Order save(Order order) {
        order.setId(++sequence);
        orderStore.put(sequence, order);
        return order;
    }

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderStore.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderStore.values());
    }

    public List<Order> findByMemberId(Long memberId) {
        return orderStore.values().stream()
                .filter(order -> order.getMember().getId().equals(memberId))
                .collect(Collectors.toList());
    }

    public void clearStore() {
        orderStore.clear();
    }
}
