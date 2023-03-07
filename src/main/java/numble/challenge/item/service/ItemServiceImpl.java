package numble.challenge.item.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.controller.dto.ItemResponseDto;
import numble.challenge.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = false)
    @Override
    public void save(Item item) {
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

    @Transactional(readOnly = false)
    @Override
    public ItemResponseDto getItemDetail(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return converToItemResponseDto(item);   //@Lob description 변수  아이템 필드가 사용된 곳에 추가...
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
    public void orderItem() {

    }

    private ItemResponseDto converToItemResponseDto(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }
}
