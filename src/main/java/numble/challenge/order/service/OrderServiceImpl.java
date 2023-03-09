package numble.challenge.order.service;

import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    public Order createOrder(Long memberId, Long itemId, int count) {
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public List<Order> findAllOrder() {
        return null;
    }

    @Override
    public void addCarTItem() {

    }

    @Override
    public void findCartItem() {

    }

    @Override
    public void CustomerSupport() {

    }

    @Override
    public void writeReview() {

    }

    @Override
    public List<Member> findAllCustomerByProduct() {
        return null;
    }
}
