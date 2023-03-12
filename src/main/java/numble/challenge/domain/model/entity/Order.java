package numble.challenge.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.challenge.domain.model.type.OrdersStatus;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @NotNull
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @NotNull
    private Item item;

    @NotNull
    private Integer count;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrdersStatus status;

    public void cancel() {
        if (status == OrdersStatus.COMPLETE) {
            throw new IllegalArgumentException("이미 배송이 완료된 상품은 취소가 불가능합니다");
        }

        item.addStock();
        status = OrdersStatus.CANCEL;
    }
}
