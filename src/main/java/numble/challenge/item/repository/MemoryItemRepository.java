//package numble.challenge.item.repository;
//
//import numble.challenge.domain.model.entity.Item;
//
//import java.util.*;
//
//public class MemoryItemRepository {
//
//    private final static Map<Long, Item> itemStore = new HashMap<>();
//    private static Long sequence = 0L;
//
//    public Item save(Item item) {
//        item.setId(++sequence);
//        itemStore.put(item.getId(), item);
//        return item;
//    }
//
//    public Optional<Item> findById(Long id) {
//        return Optional.ofNullable(itemStore.get(id));
//    }
//
//    public List<Item> findAll() {
//        return new ArrayList<>(itemStore.values());
//    }
//
//    public void storeClear() {
//        itemStore.clear();
//    }
//
//    private static synchronized void autoIncrement() {
//        MemoryItemRepository.sequence++;
//    }
//}
