package Numble.NumbleChallenge.domain.order;

import Numble.NumbleChallenge.domain.item.Item;
import Numble.NumbleChallenge.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Member member;
    private Item item;
    private Integer quantity;
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }
}
