package numble.challenge.item.service;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;

import java.util.List;


public interface ItemService {

    void save(Item item);

    void update(Long itemId, ItemRequestUpdateDto itemRequestUpdateDto);

    void delete();

    List<Item> findAllItem();

    void getItemDetail();

    void searchItem();

    void orderItem();
}
