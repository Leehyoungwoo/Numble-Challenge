package numble.challenge.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.challenge.item.controller.dto.ItemRequestSaveDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public static Item toEntity(ItemRequestSaveDto itemRequestSaveDto) {
        return Item.builder()
                .name(itemRequestSaveDto.getName())
                .price(itemRequestSaveDto.getPrice())
                .quantity(itemRequestSaveDto.getQuantity())
                .build();
    }

    public void update(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
    }

    public void sell() {
        this.quantity--;
    }
}
