package Numble.NumbleChallenge.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryItemRepository implements ItemRepository {

    private final static Map<Long, Item> itemStore = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Item save(Item item) {
        item.setId(++sequence);
        itemStore.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(itemStore.get(id));
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(itemStore.values());
    }

    public void storeClear() {
        itemStore.clear();
    }
}
