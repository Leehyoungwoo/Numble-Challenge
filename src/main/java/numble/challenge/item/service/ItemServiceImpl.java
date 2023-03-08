package numble.challenge.item.service;

import numble.challenge.domain.exception.NotEnoughStockException;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.controller.dto.ItemResponseDto;
import numble.challenge.item.repository.ItemRepository;
import numble.challenge.member.repository.MemberRepository;
import numble.challenge.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public ItemServiceImpl(ItemRepository itemRepository, MemberRepository memberRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = false)
    @Override
    public void save(Item item) {
        validateDuplicateItemName(item);
        itemRepository.save(item);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Long itemId, ItemRequestUpdateDto itemRequestUpdateDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        item.update(itemRequestUpdateDto);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Transactional(readOnly = false)
    @Override
    public List<ItemResponseDto> findAllItem() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::converToItemResponseDto)
                .collect(Collectors.toList());
    }

    // TODO: @Lob 어노테이션을 사용하여 description 필드 타입 변경 고려해보기
    @Transactional(readOnly = false)
    @Override
    public ItemResponseDto getItemDetail(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return converToItemResponseDto(item);
    }

    @Transactional(readOnly = false)
    @Override
    public List<ItemResponseDto> searchItem(String itemName) {
        List<Item> items = itemRepository.findByNameContaining(itemName);
        return items.stream()
                .map(this::converToItemResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    @Override
    public void orderItem(Long itemId, Long memberId, int count) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다"));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        if (count > item.getQuantity()) {
            throw new NotEnoughStockException("상품의 재고가 부족합니다");
        }

        item.sell();
        Order order = Order.builder()
                .member(member)
                .item(item)
                .count(count)
                .build();
        orderRepository.save(order);
    }

    private ItemResponseDto converToItemResponseDto(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }

    private void validateDuplicateItemName(Item item) {
        List<Item> items = itemRepository.findByNameContaining(item.getName());

        if (!items.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다");
        }
    }
}
