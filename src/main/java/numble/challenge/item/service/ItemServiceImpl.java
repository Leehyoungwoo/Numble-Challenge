package numble.challenge.item.service;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void update(Long itemId, ItemRequestUpdateDto itemRequestUpdateDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

        item.update(itemRequestUpdateDto);
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Item> findAllItem() {
        return null;
    }

    @Override
    public void getItemDetail() {

    }

    @Override
    public void searchItem() {

    }

    @Override
    public void orderItem() {

    }
}
