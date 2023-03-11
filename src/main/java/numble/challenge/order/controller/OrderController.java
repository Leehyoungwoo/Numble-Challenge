package numble.challenge.order.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.ItemCart;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.itemCart.repository.ItemCartRepository;
import numble.challenge.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ItemCartRepository itemCartRepository;

    @GetMapping("/api/order/new")
    public String createForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/api/order/new")
    public String create(@RequestParam Long memberId, @RequestParam Long itemId, @RequestParam int count, Model model) {
        orderService.createOrder(memberId, itemId, count);
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

    @PostMapping("/api/itemCart/{itemCartId}/add")
    public String addItemCart(@PathVariable Long itemCartId,
                              @RequestParam Long memberId,
                              @RequestParam Long itemId,
                              @RequestParam int count,
                              Model model) {
        try {
            orderService.addItemCart(itemCartId, memberId, itemId, count);
            model.addAttribute("message", "상품이 추가되었습니다");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "addItemCart-complete";
    }

    @GetMapping("/api/itemCart/{itemCartId}")
    public String findItemCart(@PathVariable Long itemCartId, Model model) {
        ItemCart itemCart = itemCartRepository.findById(itemCartId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장바구니입니다."));
        model.addAttribute("itemCart", itemCart);
        return "itemCart";
    }

    @GetMapping("api/member-by-item")
    public String findAllMemberByItem(@RequestParam("itemId") Long itemId, Model model) {
        List<Member> members = orderService.findAllMemberByProduct(itemId);
        model.addAttribute("members", members);
        return "member-by-item";
    }
}
