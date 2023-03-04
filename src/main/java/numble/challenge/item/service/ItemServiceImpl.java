package numble.challenge.item.service;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }
}
