package Numble.NumbleChallenge.domain.item;


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

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
