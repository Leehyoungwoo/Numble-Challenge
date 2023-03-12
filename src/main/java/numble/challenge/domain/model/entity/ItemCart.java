package numble.challenge.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "ItemCart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ItemCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "itemCart_Item",
    joinColumns = @JoinColumn(name = "itemCartId"))
    @MapKeyJoinColumn(name = "itemId")
    @Column(name = "count")
    private Map<Item, Integer> items = new HashMap<>();
}
