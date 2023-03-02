package Numble.NumbleChallenge.domain.item;


import lombok.Builder;

@Builder
public class Item {
    private Long id;
    private String ItemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        ItemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return ItemName;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
