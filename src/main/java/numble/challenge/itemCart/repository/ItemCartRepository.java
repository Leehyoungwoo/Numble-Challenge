package numble.challenge.itemCart.repository;

import numble.challenge.domain.model.entity.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {

}
