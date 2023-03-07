package numble.challenge.item.repository;

import numble.challenge.domain.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.name like %:name%")
    List<Item> findByNameContaining(String name);

}
