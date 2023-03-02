package Numble.NumbleChallenge.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static Map<Long, Item> itemStore = new HashMap<>();
    private static Long sequence =0L;

    public Item save(Item item) {
        item.setId(++sequence);
        itemStore.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return itemStore.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(itemStore.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearItemStore() {
        itemStore.clear();
    }
}
