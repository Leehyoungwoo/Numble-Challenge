package numble.challenge.order.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/api/order/new")
    public String createForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/api/order/new")
    public String create(@RequestParam Long memberId, @RequestParam Long itemId, @RequestParam int count, Model model) {
        orderService.createOrder(memberId,itemId,count);
        model.addAttribute("message", "주문이 완료되었습니다.");
        return "order-complete";
    }

    @PostMapping("/api/order/{orderId}/cancel")
    public String cancel(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/";
    }

    @GetMapping("/api/order")
    public String findAllOrder(Model model) {
        List<Order> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "order-list";
    }
}
