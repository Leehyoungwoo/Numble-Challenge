package numble.challenge.order.repository;

import numble.challenge.domain.model.entity.Item;
import numble.challenge.domain.model.entity.Member;
import numble.challenge.domain.model.entity.Order;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("SELECT o FROM Order o WHERE o.member.id = :memberId")
    List<Order> findByMemberId(@Param("memberId") Long memberId);

    List<Order> findByItem(Item item);

    @Query("select distinct o.member " +
            "from Order o " +
            "join o.item i " +
            "where i.id = :itemId")
    List<Member> findMemberByItem(@Param("itemId") Long itemId);
}
