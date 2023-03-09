package numble.challenge.item.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.challenge.domain.model.entity.Item;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ItemResponseDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    @Min(0)
    private Integer quantity;

}
