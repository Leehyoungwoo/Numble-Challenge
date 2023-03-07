package numble.challenge.item.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.controller.dto.ItemResponseDto;

import java.util.List;


public interface ItemService {

    void save(Item item);

    void update(Long itemId, ItemRequestUpdateDto itemRequestUpdateDto);

    void delete(Long itemId);

    List<ItemResponseDto> findAllItem();

    ItemResponseDto getItemDetail(Long itemId);

    void searchItem();

    void orderItem();
}
