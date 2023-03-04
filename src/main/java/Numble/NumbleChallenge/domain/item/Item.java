package Numble.NumbleChallenge.domain.item;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item update(Long id, String name, Integer price, Integer quantity) {
        return new Item(id, name, price, quantity);
    }
}
